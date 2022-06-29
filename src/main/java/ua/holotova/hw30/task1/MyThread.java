package ua.holotova.hw30.task1;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.printf(" Hello from %s\n", getName());
    }
}
