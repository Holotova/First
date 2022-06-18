package selfEducation.lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Iterator<S> {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        ListIterator<String> listIterator = list.listIterator();
        String first = listIterator.next();
        System.out.println("first: " + first);
        String second = listIterator.next();
        System.out.println("second: " + second);
        String third = listIterator.next();
        System.out.println("third: " + third);
        String fourth = listIterator.next();
        System.out.println("fourth: " + fourth);

        if (listIterator.hasPrevious()){
            String value = listIterator.previous();
            System.out.println("previous value: " + value);
        }

        while (listIterator.hasNext()){
            String value = listIterator.next();
            System.out.println("value: " + value);
        }

    }
}
