package ua.holotova.hw30.task2;

import java.util.List;

public class PrimeThread extends Thread {

    List<Integer> list;

    public PrimeThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.printf("Prime numbers counted by thread %s - %d\n",
                Thread.currentThread().getName(), countPrimeNumbers());
    }

    public synchronized int countPrimeNumbers() {
        int counterPrimes = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0 & list.get(i) != 1) {
                boolean isPrime = true;
                for (int j = 2; j < list.get(i); j++) {
                    if (list.get(i) % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    counterPrimes++;
                }
            }
        }
        return counterPrimes;
    }
}
