package lessons.lesson11;

public class Worker extends Data {

    @Override
    public double countSalary(double dailySalary, int workingDays) {
        double salary = dailySalary * workingDays;
        return salary;
    }

    public void printID() {
        id = 123456;
        System.out.println("ID сотрудника " + id);
    }
}
