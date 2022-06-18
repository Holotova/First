package selfEducation.lesson15;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(777);
        list.add(null);
        System.out.println("Size: " + list.size());

        Integer i = list.get(2);
        System.out.println("Element index 2: " + i);

        Integer newInt = 1000;
        Integer old = list.set(1, newInt);

        System.out.println("New value: " + list.get(1));
        System.out.println("Old value: " + old);

    }
}
