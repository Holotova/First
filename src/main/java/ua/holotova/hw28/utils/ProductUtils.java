package ua.holotova.hw28.utils;

import ua.holotova.hw28.model.NotifiableProduct;
import ua.holotova.hw28.model.Product;

import java.util.List;

public class ProductUtils {

    public int countNotificationsForNotifiableProducts(List<Product> products) {
        int notifications = (int) products
                .stream()
                .filter(it -> it.getClass().getSimpleName().equalsIgnoreCase("NotifiableProduct"))
                .map(it -> (NotifiableProduct) it)
                .count();

        return notifications;
    }
}


