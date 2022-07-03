package ua.holotova.hw31.task1;

public class MyRunnable implements Runnable {
    Resource resource;

    public MyRunnable(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.increaseResult();
    }


}
