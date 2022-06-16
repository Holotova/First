package selfEducation.lesson11.ClassWork;

public class Watchman extends Data {

    @Override
    public double countSalary(int workingDays, double daySalary) {
        double salary = daySalary*workingDays*0.5;
        return salary;
    }

    public int countNightShift(int workingDays){
        int nightShifts = workingDays/2;
        return nightShifts;
    }
}
