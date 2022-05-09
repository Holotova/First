package ua.holotova.hw15.task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Box> boxes = new TreeSet<>(new BoxComparator());
        boxes.add(new Box(10));
        boxes.add(new Box(7));
        boxes.add(new Box(300));
        boxes.add(new Box(28));
        boxes.add(new Box(50));
        boxes.add(new Box(100));
        boxes.add(new Box(0));
        printVolumes(boxes);
    }

    private static void printVolumes(Iterable<Box> list) {
        Iterator<Box> boxIterator = list.iterator();
        while (boxIterator.hasNext()) {
            System.out.println(boxIterator.next().getVolume());
        }
    }
}
