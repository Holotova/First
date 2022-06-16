package ua.holotova.hw26.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
public class Product {
    private String id;
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = UUID.randomUUID().toString();
    }
}
