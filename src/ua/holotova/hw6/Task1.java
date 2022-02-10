package ua.holotova.hw6;

public class Task1 {
    public static void main(String[] args) {
        Car myCar1 = new Car("BMW", 530, "red");
        Car myCar2 = new Car("Nissan", 160, "green");
        Car myCar3 = new Car("Renault", 110, "black");

        myCar1.setManufacturer("BMW");
        myCar2.setManufacturer("Nissan");
        myCar3.setManufacturer("Renault");

        myCar1.setEngine(530);
        myCar2.setEngine(160);
        myCar3.setEngine(110);

        myCar1.setColour("red");
        myCar2.setColour("green");
        myCar3.setColour("black");

        myCar1.setPetrol(60);
        myCar2.setPetrol(45);
        myCar3.setPetrol(52);

        System.out.println(myCar1);
        System.out.println(myCar2);
        System.out.println(myCar3);

        myCar1.startEngine("Bob ");
        myCar2.startEngine("Emmy ");
        myCar3.startEngine("Sam ");

        System.out.println(myCar1.isEnoughPetrolLevel(myCar1.petrol));
        System.out.println(myCar2.isEnoughPetrolLevel(myCar2.petrol));
        System.out.println(myCar3.isEnoughPetrolLevel(myCar3.petrol));

        Garage.checkСar(myCar1);
        Garage.checkСar(myCar2);
        Garage.checkСar(myCar3);
    }
}
