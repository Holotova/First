package ua.holotova.hw11;

import java.util.Random;

public class Samsung extends Phone {

    @Override
    public void incomingCall() {
        Random random = new Random();
        System.out.println(random.nextInt(50700000, 50799999) + " is calling");
    }

    @Override
    public void outgoingCall(int subscriberNumber) {
        System.out.println("dialing a number " + subscriberNumber);
    }


    @Override
    public void displayMobileOperator(String mobileOperator) {
        System.out.println("connected to the network " + mobileOperator);
    }

    @Override
    public void workAfterCharge() {
        workingTimeAfterCharge = 9;
        if (workingTimeAfterCharge >= 8) {
            System.out.println(this.getClass().getSimpleName() + ": Charging is OK");
        } else {
            System.out.println(this.getClass().getSimpleName() + ": ERROR");
        }
    }

    public void remindActivity() {
        System.out.println("You are sitting for more than 1 hour, time to move!");
    }
}
