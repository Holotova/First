package ua.holotova.secondModule.model;

import ua.holotova.secondModule.services.AnaliticInformation;
import ua.holotova.secondModule.services.ShopService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please set limit for the check type: ");
        Scanner scanner = new Scanner(System.in);
        Invoice.setLimit(scanner.nextInt());
        ShopService.writeFileWithInvoices();

        AnaliticInformation analiticInformation = new AnaliticInformation();
        analiticInformation.getSoldGoodsByCategory();
        analiticInformation.getSumOfAllChecks();
        analiticInformation.firstThreeChecks();
        analiticInformation.countRetailChecks();
        analiticInformation.getMinSumOfCheck();
        analiticInformation.getChecksWithOneKindOfGoods();
        analiticInformation.getUnder18Checks();
        analiticInformation.sortAllOrders();
    }
}
