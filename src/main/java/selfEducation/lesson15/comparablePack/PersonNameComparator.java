package selfEducation.lesson15.comparablePack;

import java.util.Comparator;

class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
}
