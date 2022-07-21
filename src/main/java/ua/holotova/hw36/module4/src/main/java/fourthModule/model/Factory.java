package fourthModule.model;

import fourthModule.runnable.BasicDetailProduction;
import fourthModule.runnable.FinishDetailRunnable;
import fourthModule.runnable.FuelRunnable;
import fourthModule.runnable.ProgrammingChipRunnable;

public class Factory {
    public void startProduction() throws InterruptedException {
        Runnable fuel = new FuelRunnable();
        Runnable basicDetail = new BasicDetailProduction();
        Runnable programChip = new ProgrammingChipRunnable();
        Runnable finishDetail = new FinishDetailRunnable();

        Thread fuelRobot1 = new Thread(fuel);
        fuelRobot1.setDaemon(true);
        fuelRobot1.setName("Robot 1");
        fuelRobot1.start();

        Thread basicDetailRobot2 = new Thread(basicDetail);
        Thread basicDetailRobot3 = new Thread(basicDetail);
        basicDetailRobot2.setName("Robot 2");
        basicDetailRobot2.start();
        basicDetailRobot3.setName("Robot 3");
        basicDetailRobot3.start();
        basicDetailRobot2.join();
        basicDetailRobot3.join();

        Thread programRobot4 = new Thread(programChip);
        programRobot4.setName("Robot 4");
        programRobot4.start();
        programRobot4.join();

        Thread finishRobot5 = new Thread(finishDetail);
        finishRobot5.setName("Robot 5");
        finishRobot5.start();
        finishRobot5.join();
    }
}
