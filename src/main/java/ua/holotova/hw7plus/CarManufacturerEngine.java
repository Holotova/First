/*
package ua.holotova.hw7plus;

public class CarManufacturerEngine {

    public static void main(String[] args) {
        Car myCar1 = new Car(Manufacturer.BMW, Engine, "red");
        Car myCar2 = new Car(Manufacturer.NISSAN, Engine, "green");
        Car myCar3 = new Car(Manufacturer.RENAULT, Engine, "black");

        System.out.println(myCar1);
        System.out.println(myCar2);
        System.out.println(myCar3);

        }
}
class Car {
    Manufacturer manufacturer;
    Engine engine;
    String colour;
    int petrol;

    public Car(Manufacturer manufacturer, Engine engine, String colour) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.colour = colour;
        this.petrol = 100;
    }

    @Override
    public String toString() {
        return "Car " +
                "manufacturer " + manufacturer +
                ", engine: " + engine +
                ", colour: " + colour +
                ", petrol: " + petrol;
    }
}
enum Manufacturer {
    BMW("БМВ"),
    NISSAN("Ниссан"),
    RENAULT("Рено");

    public String russianName;

    Manufacturer(String russianName ){
        this.russianName  = russianName ;
    }
    @Override
    public String toString() {
        return " russianName: " + russianName;
    }
}
class Engine {
    int power;
    String type;

    Engine(int power){
        this.power = power;
        this.type = "л.с.";
    }

    @Override
    public String toString() {
        return "Engine " +
                power +
                type;
    }
}
*/
