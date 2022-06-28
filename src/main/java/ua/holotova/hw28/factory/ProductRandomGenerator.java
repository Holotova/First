package ua.holotova.hw28.factory;

import ua.holotova.hw28.model.NotifiableProduct;
import ua.holotova.hw28.model.Product;
import ua.holotova.hw28.model.ProductBundle;
import ua.holotova.hw28.model.ProductType;

import java.util.Random;

import static ua.holotova.hw28.model.ProductType.PRODUCT_BUNDLE;
import static ua.holotova.hw28.model.ProductType.PRODUCT_NOTIFIABLE;

public class ProductRandomGenerator {
    public static final Random RANDOM = new Random();

    public Product generateRandomProduct() {
        Product product;
        if (RANDOM.nextBoolean()) {
            product = createProduct(PRODUCT_BUNDLE);
        } else {
            product = createProduct(PRODUCT_NOTIFIABLE);
        }
        return product;
    }

    private Product createProduct(ProductType type) {
        switch (type) {
            case PRODUCT_BUNDLE: return new ProductBundle
                        .ProductBundleBuilder()
                        .amount(RANDOM.nextInt(15))
                        .available(RANDOM.nextBoolean())
                        .channel(RANDOM.nextBoolean() + "" + RANDOM.nextDouble())
                        .price(RANDOM.nextDouble())
                        .id(RANDOM.nextLong())
                        .title(RANDOM.nextFloat() + "" + RANDOM.nextDouble())
                        .build();
            case PRODUCT_NOTIFIABLE: return new NotifiableProduct
                        .NotifiableProductBuilder()
                        .id(RANDOM.nextLong())
                        .title(RANDOM.nextFloat() + "" + RANDOM.nextDouble())
                        .available(RANDOM.nextBoolean())
                        .channel(RANDOM.nextBoolean() + "" + RANDOM.nextDouble())
                        .price(RANDOM.nextDouble())
                        .build();
            default:
                throw new IllegalStateException("No such type of product: " + type);
        }
    }
}
