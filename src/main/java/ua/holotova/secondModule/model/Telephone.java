package ua.holotova.secondModule.model;

import lombok.Getter;

@Getter
public class Telephone extends Technics {
    String model;


    public Telephone(String series, String screenType, Integer price, String model) {
        super(series, screenType, price);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                "} ";
    }
}
