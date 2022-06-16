package selfEducation.lesson11.ClassWork;

public abstract class Data {
    protected int workingDays;
    protected String name;
    protected double daySalary;

    public abstract double countSalary (int workingDays, double daySalary);
}
