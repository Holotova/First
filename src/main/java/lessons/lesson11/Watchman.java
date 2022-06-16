package lessons.lesson11;

public class Watchman extends Data {


    @Override
    public double countSalary(double dailySalary, int workingDays) {
        double salary = dailySalary*workingDays;
        return salary;
    }
    public void printName (){
        name = "Billy";
        System.out.println("Имя сотрудника " + name);
    }
}
