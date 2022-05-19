package ua.holotova.hw18;

import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class Box {
    private String from;
    private String material;
    private String color;
    private MaxLiftingCapacity maxLiftingCapacity;
    private Cargo cargo;
    LocalDateTime date;

    @Override
    public String toString() {
        return String.format("from - %s\n material - %s\n color - %s\n maxLiftingCapacity - %s\n cargo - %s\n date - %s", from, material, color, maxLiftingCapacity, cargo, date);
    }
}

@Setter
class MaxLiftingCapacity {
    private String unit;
    private Integer value;

    @Override
    public String toString() {

        return String.format(" (unit - %s, value - %d)", unit, value);
    }
}

@Setter
class Cargo {
    private String name;
    private String classs;

    @Override
    public String toString() {
        return String.format(" (name - %s, class - %s)", name, classs);
    }
}

