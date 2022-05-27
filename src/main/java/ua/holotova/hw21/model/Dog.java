package ua.holotova.hw21.model;

import lombok.ToString;
import ua.holotova.hw21.interfaces.AutoCreate;
import ua.holotova.hw21.interfaces.Init;
import ua.holotova.hw21.interfaces.Multiplier;

@ToString
@AutoCreate
public class Dog {
    private final String name = "Elsa";
    @Multiplier(operation = "multiplication")
    private final Integer age = 3;
    @Multiplier()
    private final Integer weight = 12;

    @Init
    public static void init(){
        System.out.println("Dog barks");
    }
}
