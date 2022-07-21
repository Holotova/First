package fourthModule.runnable;

import static fourthModule.service.DetailProduction.RANDOM;


public class BasicDetailProduction implements Runnable {
    private static final Object LOCK = new Object();
    private int constructionProgress = 0;
    public static long startDetailTime = 0;

    @Override
    public void run() {
        startDetailTime = System.currentTimeMillis();
        while (constructionProgress < 100) {
            constructBasicDetail();
        }
    }

    public void constructBasicDetail() {
        synchronized (LOCK) {
            try {
                constructionProgress += RANDOM.nextInt(10, 21);
                Thread.sleep(2000);
                System.out.println(constructionProgress + " points done by " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}



