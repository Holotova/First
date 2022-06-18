package selfEducation.lesson6.klass;

public class Lesson6_klass {
    public static void main(String[] args) {
        Phone phone1 = new Phone(333, "Samsung");
        Phone phone2 = new Phone(2002, "iPhone", 30.3);
        Phone phone3 = new Phone();

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.receiveCall("Ivan");
        phone2.receiveCall("Stepan");
        phone3.receiveCall("Miron");

        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());
    }
}

