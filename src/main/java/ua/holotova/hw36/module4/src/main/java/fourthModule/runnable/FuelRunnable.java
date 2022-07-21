package fourthModule.runnable;

import fourthModule.service.DetailProduction;

public class FuelRunnable implements Runnable{
    public static final DetailProduction DETAIL_PRODUCTION = new DetailProduction();
    @Override
    public void run() {
        DETAIL_PRODUCTION.getFuel();
    }
}
