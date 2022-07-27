package fourthModule.service;

import fourthModule.dao.DetailDao;
import fourthModule.model.Detail;

import java.time.LocalDate;
import java.util.Random;

import static fourthModule.runnable.BasicDetailProduction.startDetailTime;

public class DetailProduction {
    public static final DetailDao DETAIL_DAO = new DetailDao();
    private Integer fuel = 0;
    private Integer generalExtractedFuel = 0;
    public static final Random RANDOM = new Random();
    private Integer brokenChips = 0;
    private long finishDetailTime;
    private long timeForOneDetail;


    public void getFuel() {
        while (true) {
            Integer extractedFuel = RANDOM.nextInt(500, 1001);
            generalExtractedFuel += extractedFuel;
            fuel += extractedFuel;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void programChip() {
        int programmingProgress = 0;
        try {
            do {
                programmingProgress += RANDOM.nextInt(25, 36);
                Thread.sleep(1000);
                if (RANDOM.nextInt(0, 101) <= 30) {
                    programmingProgress = 0;
                    brokenChips++;
                }
                System.out.println(programmingProgress + " points done by " + Thread.currentThread().getName() +
                        ". Broken chips " + brokenChips);
            } while (programmingProgress < 100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void finishDetail() {
        int finishProgress = 0;
        try {
            do {
                finishProgress += 10;
                Thread.sleep(1000);
                fuel -= RANDOM.nextInt(350, 701);
                while (fuel < 0) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is waiting for fuel");
                }
                System.out.println(finishProgress + " points done by " + Thread.currentThread().getName());
            } while (finishProgress < 100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finishDetailTime = System.currentTimeMillis();
        timeForOneDetail = (finishDetailTime - startDetailTime) / 1000;
        Detail detail = new Detail(LocalDate.now(), timeForOneDetail, generalExtractedFuel, brokenChips);
        DETAIL_DAO.save(detail);
        System.out.println("DETAIL READY");
        System.out.println(detail);
    }
}

