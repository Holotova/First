package ua.holotova.hw30.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List <MyThread> threads = new ArrayList<>(50);
        for (int i = 0; i < 50; i++) {
            threads.add(new MyThread());
        }
        for (int j = threads.size() - 1; j >= 0; j--) {
            final MyThread thread = threads.get(j);
            thread.start();
            thread.join();
        }
    }
}

