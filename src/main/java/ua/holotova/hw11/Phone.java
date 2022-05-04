package ua.holotova.hw11;

public abstract class Phone {
    protected String model;
    protected String mobileOperator;
    protected int subscriberNumber;
    protected int workingTimeAfterCharge;


    public abstract void incomingCall();

    public abstract void outgoingCall(int subscriberNumber);

    public abstract void displayMobileOperator(String mobileOperator);

    public abstract void workAfterCharge();
}
