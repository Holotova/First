package ua.holotova.hw21.model;

import lombok.ToString;
import ua.holotova.hw21.interfaces.AutoCreate;
import ua.holotova.hw21.interfaces.Init;
import ua.holotova.hw21.interfaces.Multiplier;

@ToString
@AutoCreate
public class Cat {
    @Multiplier()
    private final String name = "Jack";
    @Multiplier()
    private final Integer age = 10;
    @Multiplier(operation = "multiplication")
    private final Double weight = 9.2;

    @Init
    public static void init() {
        System.out.println("Cat meows");
    }

}
