package selfEducation.lesson10;

public class Car {
    int serialNumber;
    int year;
    String color;
    double fuel;

    public Car(int serialNumber, int year, String color, double fuel) {
        this.serialNumber = serialNumber;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
    }

    public void run(int distance) {
        double fuelConsumption = 0.1;
        int vehicleRange = (int) (fuel / fuelConsumption);
        if (fuel == 0) {
            System.out.println("Закончилось топливо!");
        } else if (vehicleRange >= distance) {
            System.out.println("Топлива достаточно. Расчетный запас хода автомобиля " + vehicleRange + " км");
        } else {
            System.out.println("Топлива недостаточно для поездки на это расстояние. Требуется дозаправка. Расчетный запас хода автомобиля " + vehicleRange + " км");
        }
    }


    @Override
    public String toString() {
        return "Car{" +
                "serialNumber=" + serialNumber +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", fuel=" + fuel +
                '}';
    }
}
