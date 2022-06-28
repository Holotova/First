package ua.holotova.hw28.model;

import lombok.Getter;

@Getter
public class NotifiableProduct extends Product {
    protected String channel;

    protected NotifiableProduct() {
    }

    @Override
    public String toString() {
        return "NotifiableProduct " +
                "(channel = " + channel +
                ", id = " + id +
                ", available = " + available +
                ", title = '" + title +
                ", price = " + price + ")";
    }
    @Getter
    public static class NotifiableProductBuilder {

        private long id;
        private boolean available;
        private String title;
        private double price;
        private String channel;

        public NotifiableProductBuilder id(long id) {
            this.id = id;
            return this;
        }

        public NotifiableProductBuilder available(boolean available) {
            this.available = available;
            return this;
        }

        public NotifiableProductBuilder title(String title) {
            this.title = title;
            return this;
        }

        public NotifiableProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        public NotifiableProductBuilder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public NotifiableProduct build() {
            NotifiableProduct notifiableProduct = new NotifiableProduct();
            notifiableProduct.id = this.getId();
            notifiableProduct.available = this.isAvailable();
            notifiableProduct.title = this.getTitle();
            notifiableProduct.price = this.getPrice();
            notifiableProduct.channel = this.getChannel();
            return notifiableProduct;
        }
    }
}