package selfEducation.lesson11.ClassWork;

public class Accountant extends Data {
    @Override
    public double countSalary(int workingDays, double daySalary) {
        double salary = daySalary*workingDays*1.5;
        return salary;
    }

    public int countReports (int workingDays){
        int reports = workingDays*25;
        return reports;
    }
}
