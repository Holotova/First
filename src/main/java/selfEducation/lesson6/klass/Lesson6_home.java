package selfEducation.lesson6.klass;

public class Lesson6_home {
    public static void main(String[] args) {
        Car car1 = new Car(Manufacturer.VOLVO, 200, "Black");
        Car car2 = new Car(Manufacturer.NISSAN, 1020, "Red");
        Car car3 = new Car(Manufacturer.BMW, 800, "Green");

        car1.setColour("Black");
        car2.setEngine(150);


        System.out.println(car1.isEnoughPetrolLevel(200));
        System.out.println(car2.isEnoughPetrolLevel(car2.petrol));
        System.out.println(car3.isEnoughPetrolLevel(49));

        car1.startEngine("Ben");
        car2.startEngine("Sem");
        car3.startEngine("Bob");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println();
        Garage.checkCar(car1);
        Garage.checkCar(car2);
        Garage.checkCar(car3);
    }
}
