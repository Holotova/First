package selfEducation.lesson6.phone;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone(11, "  ", 25.0);
        Phone phone2 = new Phone(22, "mlkm");
        Phone phone3 = new Phone();

        phone1.model = "Samsung";
        phone2.model = "Apple";
        phone3.model = "Nokia";

        phone1.number = 777;
        phone2.number = 111;
        phone3.number = 999;

        phone1.weight = 1.2;
        phone2.weight = 2.4;
        phone3.weight = 3.5;

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.receiveCall("Serg");
        phone2.receiveCall("Masha");
        phone3.receiveCall("Olga");

        phone1.setNumber(111);
        phone2.setNumber(222);
        phone3.setNumber(333);

        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());


    }
}
