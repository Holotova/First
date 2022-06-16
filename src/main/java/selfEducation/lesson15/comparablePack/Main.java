package selfEducation.lesson15.comparablePack;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<Person> pComp = new PersonNameComparator().thenComparing(new PersonAgeComparator());
        TreeSet<Person> people = new TreeSet<>(pComp);
        people.add(new Person("Tom", 23));
        people.add(new Person("Nick", 34));
        people.add(new Person("Tom", 10));
        people.add(new Person("Bill", 14));


        System.out.println(people.first());
    }
}
