package ua.holotova.hw21.model;

import lombok.ToString;
import ua.holotova.hw21.interfaces.AutoCreate;
import ua.holotova.hw21.interfaces.Init;
import ua.holotova.hw21.interfaces.Multiplier;

@ToString
@AutoCreate
public class Mouse {
    private final String name = "Jerry";
    @Multiplier(operation = "multiplication")
    private final Integer age = 2;
    @Multiplier()
    private final Integer weight = 1;

    @Init
    public static void init(){
        System.out.println("Mouse squeaks");
    }
}
