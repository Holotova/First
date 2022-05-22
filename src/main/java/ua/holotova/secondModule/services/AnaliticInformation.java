package ua.holotova.secondModule.services;

import ua.holotova.secondModule.model.Invoice;

import java.util.LinkedList;

public class AnaliticInformation {
    static LinkedList<Invoice> fifteenOrdersList = ShopService.generateFifteenOrders();

    public static void getSoldGoodsByCategory() {
        fifteenOrdersList.stream()
                .forEach(System.out::println);

        long countTelephones = fifteenOrdersList.stream()
                .flatMap(s -> s.getTechnics().stream())
                .map(s -> s.getClass().getSimpleName())
                .filter(s -> s.equalsIgnoreCase("Telephone"))
                .count();
        System.out.println("Telephones were sold - " + countTelephones);
        long countTelevisions = fifteenOrdersList.stream()
                .flatMap(s -> s.getTechnics().stream())
                .map(s -> s.getClass().getSimpleName())
                .filter(s -> s.equalsIgnoreCase("Television"))
                .count();
        System.out.println("Televisions were sold - " + countTelevisions);
    }

    public static void getSumOfAllChecks() {
        int sum = fifteenOrdersList.stream()
                .flatMap(s -> s.getTechnics().stream())
                .map(s -> s.getPrice())
                .mapToInt(s -> s)
                .sum();
        System.out.println("Sum of all checks - " + sum);

    }

    public static void firstThreeChecks() {
        System.out.println("Three first Invoices: ");
        fifteenOrdersList.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    public static void countRetailChecks() {
        long retailChecks = fifteenOrdersList.stream()
                .filter(s -> s.getType().equalsIgnoreCase("retail"))
                .count();
        System.out.println("Retail checks: " + retailChecks);
    }
}


