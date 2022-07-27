package fourthModule.runnable;

import static fourthModule.runnable.FuelRunnable.DETAIL_PRODUCTION;

public class FinishDetailRunnable implements Runnable {

    @Override
    public void run() {
        DETAIL_PRODUCTION.finishDetail();
    }
}
