package ua.holotova.hw28;

import ua.holotova.hw28.model.Product;
import ua.holotova.hw28.utils.ProductRepository;
import ua.holotova.hw28.utils.ProductUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ProductUtils productUtils = new ProductUtils();
        List<Product> products = productRepository.generateProductList();

        System.out.println("General list of products: ");
        products.forEach(System.out::println);
        System.out.println("_____________________________");
        System.out.println("Notifications were sent: " +
                productUtils.countNotificationsForNotifiableProducts(products));
    }
}
