package ua.holotova.hw28.model;

import lombok.Data;

@Data
public abstract class Product{
    protected long id;
    protected boolean available;
    protected String title;
    protected double price;
}