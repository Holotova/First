package ua.holotova.hw7;

public class Car {
    String manufacturer;
    int engine;
    String colour;
    int petrol;

    public Car(String manufacturer, int engine, String colour) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.colour = colour;
        this.petrol = 100;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public String toString() {
        return "Car " +
                "manufacturer: " + manufacturer +
                ", engine: " + engine +
                ", colour: " + colour +
                ", petrol: " + petrol;
    }

    public void startEngine(String name) {
        System.out.println(name + "запустил двигатель");
    }

    public boolean isEnoughPetrolLevel(int petrol) {
        boolean isEnough;
        if (this.petrol < 50) {
            isEnough = false;
        } else {
            isEnough = true;
        }
        return isEnough;
    }
}
