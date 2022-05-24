package ua.holotova.secondModule.model;

import lombok.Getter;

@Getter
public class Technics {
    String series;
    String screenType;
    Integer price;

    public Technics(String series, String screenType, Integer price) {
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }
}
