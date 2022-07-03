package ua.holotova.hw31.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.result = 50;
        Runnable counter = new MyRunnable(resource);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.submit(counter);
        }
        executor.shutdown();
    }
}

