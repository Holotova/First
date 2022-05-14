/*
Напишите метод, который добавляет 100000 элементов в ArrayList и LinkedList.
Напишите еще один метод, который выбирает из заполненного списка элемент наугад 100000 раз.
Замерьте время, которое потрачено на это.
*/
package ua.holotova.hw16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        addElementsToList(arrayList);
        long finish = System.nanoTime();
        System.out.printf("Time for filling ArrayList: %d msec%n", (finish - start) / 1000000);

        long start2 = System.nanoTime();
        addElementsToList(linkedList);
        long finish2 = System.nanoTime();
        System.out.printf("Time for filling LinkedList: %d msec%n", (finish2 - start2) / 1000000);

        long start3 = System.nanoTime();
        chooseElementsFromList(arrayList);
        long finish3 = System.nanoTime();
        System.out.printf("Time for choosing 100 000 elements from ArrayList: %d msec%n", (finish3 - start3) / 1000000);

        long start4 = System.nanoTime();
        chooseElementsFromList(linkedList);
        long finish4 = System.nanoTime();
        System.out.printf("Time for choosing 100 000 elements from LinkedList: %d msec%n", (finish4 - start4) / 1000000);
    }

    private static void addElementsToList(List<Integer> list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);

        }
    }

    private static void chooseElementsFromList(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            random.nextInt(list.size());
        }
    }
}
