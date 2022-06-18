package selfEducation.lesson11.ClassWork;

public class Main {
    public static void main(String[] args) {
        Data watchman = new Watchman();
        Data worker = new Worker();
        Data accountant = new Accountant();
        Data director = new Director();

        System.out.println(watchman.countSalary(30, 500));
        System.out.println(worker.countSalary(20, 600));
        System.out.println(accountant.countSalary(22, 1200));
        System.out.println(director.countSalary(25, 2500));

        if (watchman instanceof Watchman wat) {
            System.out.println("Ночных смен - " + wat.countNightShift(30));
        }
        if (worker instanceof Worker wor) {
            System.out.println("Сделал деталей за месяц: " + wor.countDetails(20));
        }
        if (accountant instanceof Accountant acc) {
            System.out.println("Сдала отчетов за месяц: " + acc.countReports(22));
        }
        if (director instanceof Director dir) {
            System.out.println("Получил премию: " + dir.countPremium(25));
        }

    }
}
