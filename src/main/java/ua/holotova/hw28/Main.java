package ua.holotova.hw28;

import ua.holotova.hw28.model.Product;
import ua.holotova.hw28.utils.ProductRepository;
import ua.holotova.hw28.utils.ProductUtils;

import java.util.List;

public class Main {
    private static final ProductRepository PRODUCT_REPOSITORY = new ProductRepository();
    private static final ProductUtils PRODUCT_UTILS = new ProductUtils();
    private static final List<Product> PRODUCTS = PRODUCT_REPOSITORY.generateProductList();
    public static void main(String[] args) {


        System.out.println("General list of products: ");
        PRODUCTS.forEach(System.out::println);
        System.out.println("_____________________________");
        System.out.println("Notifications were sent: " +
                PRODUCT_UTILS.countNotificationsForNotifiableProducts(PRODUCTS));
    }
}
