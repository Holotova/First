package ua.holotova.hw21.model;

import lombok.ToString;
import ua.holotova.hw21.interfaces.AutoCreate;
import ua.holotova.hw21.interfaces.Init;
import ua.holotova.hw21.interfaces.Multiplier;

@ToString
@AutoCreate
public class Cat {
    private final String name = "Jack";
    @Multiplier()
    private final Integer age = 10;
    @Multiplier(operation = "multiplication")
    private final Integer weight = 9;

    @Init
    public static void init(){
        System.out.println("Сat meows");
    }

}
