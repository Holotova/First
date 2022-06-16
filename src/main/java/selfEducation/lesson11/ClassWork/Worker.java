package selfEducation.lesson11.ClassWork;

public class Worker extends Data {
    @Override
    public double countSalary(int workingDays, double daySalary) {
        double salary = daySalary*workingDays;
        return salary;
    }
    public int countDetails (int workingDays){
        int details = workingDays*550;
        return details;
    }
}
