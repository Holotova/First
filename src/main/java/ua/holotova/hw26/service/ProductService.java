package ua.holotova.hw26.service;

import ua.holotova.hw26.dao.ProductDao;
import ua.holotova.hw26.model.Product;

import java.util.Arrays;

import static ua.holotova.hw26.dao.AbstractDao.DB;


public class ProductService {

    public static final ProductDao PRODUCT_DAO = new ProductDao(DB);

    public void createProducts() {
        final Product product1 = new Product("Phone", 15000, 10);
        final Product product2 = new Product("TV", 25000, 3);
        final Product product3 = new Product("Monitor", 12000, 4);
        final Product product4 = new Product("Notebook", 45000, 2);
        final Product product5 = new Product("Player", 3000, 12);
        final Product product6 = new Product("Oven", 24000, 1);
        final Product product7 = new Product("Blender", 5000, 7);
        final Product product8 = new Product("Mixer", 2000, 4);
        PRODUCT_DAO.insertMany(Arrays.asList(product1, product2, product3, product4,
                product5, product6, product7, product8));
    }

    public void printAllProducts() {
        System.out.println("All products:");
        PRODUCT_DAO.findAll().forEach(System.out::println);
    }
}
