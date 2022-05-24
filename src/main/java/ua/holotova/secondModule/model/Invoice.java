package ua.holotova.secondModule.model;

import lombok.Getter;

import java.util.List;


@Getter
public class Invoice {
    private String date;
    private Customer customer;
    private String type;
    private List<Technics> technics;
    static int limit;

    public static String setType(String s) {
        return s;
        }

    public static String chooseInvoiceType(List<Technics> techno) {
        int amountOfCheck = techno.stream()
                .map(s -> s.getPrice())
                .mapToInt(s -> s)
                .sum();
        if (amountOfCheck >= getLimit()) {
            return "wholesale";
        } else {
            return "retail";
        }
    }

    public static int getLimit() {
        return limit;
    }

    public static void setLimit(int limit) {
        Invoice.limit = limit;
    }

    public Invoice(String date, Customer customer, String type, List<Technics> technics) {
        this.date = date;
        this.customer = customer;
        this.type = type;
        this.technics = technics;
    }

    @Override
    public String toString() {
        return "Invoice: " + date + " " + type + " " + customer + "\n" +  technics;
    }
}



