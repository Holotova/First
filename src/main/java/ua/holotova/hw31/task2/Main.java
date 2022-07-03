package ua.holotova.hw31.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ua.holotova.hw31.task2.RaceRegistration.HORSES;

public class Main {
    private static final RaceRegistration RACE_REGISTRATION = new RaceRegistration();


    public static void main(String[] args) {

        RACE_REGISTRATION.chooseNumberOfParticipants();
        RACE_REGISTRATION.chooseHorseNumber();

        Runnable racing = new HorseRunnable();
        ExecutorService executor = Executors.newFixedThreadPool(HORSES);
        for (int i = 0; i < HORSES; i++) {
            executor.submit(racing);
        }
        executor.shutdown();
    }
}

