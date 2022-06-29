package ua.holotova.hw30.task1;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<MyThread> threads = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            threads.add(new MyThread());
        }
        for (int j = threads.size() - 1; j >= 0; j--) {
            threads.get(j).start();
            threads.get(j).join();
        }
    }
}

