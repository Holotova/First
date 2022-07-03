package ua.holotova.hw31.task2;

public class HorseRunnable implements Runnable {
    HorseRacing horseRacing = new HorseRacing();

    @Override
    public void run() {
        horseRacing.declareRunningResult();
    }


}

