package selfEducation.lesson15.comparablePack;

import java.util.Comparator;

public class Person implements Comparator<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compare(Person a, Person b) {
        return 0;
    }
}
