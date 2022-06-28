package ua.holotova.hw28.model;

import lombok.Getter;


public class ProductBundle extends NotifiableProduct {
    protected int amount;

    private ProductBundle() {
    }

    @Override
    public String toString() {
        return "ProductBundle " +
                "(amount=" + amount +
                ", channel = " + channel +
                ", id = " + id +
                ", available = " + available +
                ", title = '" + title +
                ", price = " + price + ")";
    }

    @Getter
    public static class ProductBundleBuilder extends NotifiableProductBuilder {
        private int amount;

        public ProductBundleBuilder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public ProductBundle build() {
            ProductBundle productBundle = new ProductBundle();
            productBundle.id = this.getId();
            productBundle.available = this.isAvailable();
            productBundle.title = this.getTitle();
            productBundle.price = this.getPrice();
            productBundle.channel = this.getChannel();
            productBundle.amount = this.getAmount();
            return productBundle;
        }
    }
}