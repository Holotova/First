package test;

import java.util.Random;

public class PersonFactory {
    private static final Random RANDOM = new Random();

    public Person createPerson(){

        return new Person(RANDOM.nextInt(80), "Person" + RANDOM.nextInt(80));
    }
}
