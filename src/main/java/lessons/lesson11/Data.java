package lessons.lesson11;

public abstract class Data {
    protected int id;
    protected String name;
    protected Double dailySalary;
    protected int workingDays;
    protected int penalty;

    public abstract double countSalary(double dailySalary, int workingDays);

}
