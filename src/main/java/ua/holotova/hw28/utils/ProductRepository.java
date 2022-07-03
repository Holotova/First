package ua.holotova.hw28.utils;


import ua.holotova.hw28.factory.ProductRandomGenerator;
import ua.holotova.hw28.model.Product;

import java.util.ArrayList;
import java.util.List;

import static ua.holotova.hw28.factory.ProductRandomGenerator.RANDOM;

public class ProductRepository {

    private final ProductRandomGenerator GENERATOR = new ProductRandomGenerator();

    public List<Product> generateProductList() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < RANDOM.nextInt(5, 20); i++) {
            products.add(GENERATOR.generateRandomProduct());
        }
        return products;
    }
}
