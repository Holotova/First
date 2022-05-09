package ua.holotova.hw15.task1;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        MyList<String> stringMyList = new MyList<>();
        stringMyList.add("one");
        stringMyList.add("two");
        stringMyList.add("three");
        stringMyList.add("four");
        stringMyList.add("five");

        Optional<Integer> opt;
        opt = stringMyList.getFromLast("four");
        if (opt.isPresent()) {
            System.out.printf(("Element has index %d in the List %n"), opt.get());
        } else {
            System.out.println("Element not found");
        }
    }
}
