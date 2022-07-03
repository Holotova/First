package ua.holotova.hw31.task1;

import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    int result;
    ReentrantLock lock = new ReentrantLock();

    public void increaseResult() {
        lock.lock();
        try {
            result += 2;
            System.out.println(result + " " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }
}
