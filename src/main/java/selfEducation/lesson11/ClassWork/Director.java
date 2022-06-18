package selfEducation.lesson11.ClassWork;

public class Director extends Data {
    @Override
    public double countSalary(int workingDays, double daySalary) {
        double salary = daySalary*workingDays*2;
        return salary;
    }
    public double countPremium (int workingDays){
        double premium = workingDays*20;
        return premium;
    }
}
