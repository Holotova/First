package ua.holotova.hw23.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Factory {
    String factoryId;
    String name;
    String country;

    public Factory() {
    }
}
