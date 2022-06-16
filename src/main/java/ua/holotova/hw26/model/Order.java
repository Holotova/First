package ua.holotova.hw26.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Order {
    private String id;
    private List<String> products;
    private String date;
    private String customerId;

    public Order() {
        this.date = LocalDate.now().toString();
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format("Order: ID: %s. Date: %s. CustomerID: %s. Products: %s", id, date, customerId, products);
    }
}
