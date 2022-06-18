package selfEducation.lesson15.comparablePack;

import java.util.Comparator;
import java.util.TreeSet;

public class PersonComparator implements Comparator <Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    PersonComparator personComparator = new PersonComparator();
    TreeSet<Person> people = new TreeSet<>(personComparator);
    
}
