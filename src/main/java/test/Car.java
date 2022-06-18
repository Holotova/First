package test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
   private Person[] persons = new Person[4];
   private String color;
   private int version;
}
