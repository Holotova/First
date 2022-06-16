package selfEducation.lesson6.klass;

public class Car {
    Manufacturer manufacturer;
    int engine;
    String colour;
    int petrol;

    public Car(Manufacturer manufacturer, int engine, String colour) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.colour = colour;
        petrol = 80;
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
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", engine=" + engine +
                ", colour='" + colour + '\'' +
                ", petrol=" + petrol +
                '}';
    }

    public void startEngine(String name) {
        System.out.println(name + " запустил двигатель");
    }

    public boolean isEnoughPetrolLevel(int petrol) {
        boolean isEnough = true;
        if (petrol < 50) {
            isEnough = false;
        }
        return isEnough;
    }
}

