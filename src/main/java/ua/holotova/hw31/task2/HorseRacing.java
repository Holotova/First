package ua.holotova.hw31.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static ua.holotova.hw31.task2.RaceRegistration.CUSTOM_HORSE_NUMBER;
import static ua.holotova.hw31.task2.RaceRegistration.HORSES;

public class HorseRacing {
    private static final String PREFIX_HORSE_NAME = "pool-1-thread-";
    private static final Random RANDOM = new Random();
    private List<String> horseList = new ArrayList<>();
    private List<Long> resultTable = new ArrayList<>();
    private List<Long> sortedResultTable;
    private long customResult;
    private int place;
    private String customHorse = PREFIX_HORSE_NAME + CUSTOM_HORSE_NUMBER;

    public long getRunTime() {
        long startTime = System.currentTimeMillis();
        int distance1 = 0;
        int interval = RANDOM.nextInt(100, 200);
        for (int distance = 0; distance <= 1000; distance++) {
            int distance2 = distance1 + interval;
            if (distance == distance2) {
                try {
                    Thread.sleep(RANDOM.nextInt(400, 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                distance1 = distance2;
                interval = RANDOM.nextInt(100, 200);
            }
        }
        long finishTime = System.currentTimeMillis();
        long runTime = finishTime - startTime;
        return runTime;
    }

    public void declareRunningResult() {
        long runTime = getRunTime();
        horseList.add(Thread.currentThread().getName());
        resultTable.add(runTime);
        sortedResultTable = resultTable.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < horseList.size(); i++) {
            if (horseList.get(i).equalsIgnoreCase(customHorse)) {
                customResult = resultTable.get(i);
            }
        }
        place = sortedResultTable.indexOf(customResult);

        if (horseList.size() == HORSES) {
            if (place == 0) {
                System.out.printf("Your horse finished first with result %d\n" +
                        "Congratulations!!! You are winner!!!", customResult);
            } else {
                System.out.printf("Your horse finished %d with result %d\n", place + 1, customResult);
            }
        }
    }
}
