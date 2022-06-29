package ua.holotova.hw30.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> fullList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            fullList.add(i);
        }
        final List<Integer> firstSubList = new ArrayList<>();
        final List<Integer> secondSubList = new ArrayList<>();

        for (int i = 0; i < fullList.size(); i++) {
            if (i % 2 == 0) {
                firstSubList.add(fullList.get(i));
            } else {
                secondSubList.add(fullList.get(i));
            }
        }

        PrimeThread thread1 = new PrimeThread(firstSubList);
        PrimeThread thread2 = new PrimeThread(secondSubList);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.printf("Total number of Primes: %d\n", thread1.countPrimeNumbers() + thread2.countPrimeNumbers());
    }
}
