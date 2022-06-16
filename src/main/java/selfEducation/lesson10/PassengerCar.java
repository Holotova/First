package selfEducation.lesson10;

public class PassengerCar extends Car implements Recovery {
    PassengerCar passenger;

    public PassengerCar(int serialNumber, int year, String color, double fuel) {
        super(serialNumber, year, color, fuel);
    }

    public void setPassenger(int passenger) {
        if (passenger > 3) {
            passenger = 3;
            System.out.println("В автомобиле должно быть только 3 пассажира, остальных высадили");
        } else {
            System.out.println("В автомобиле " + passenger + " пассажир(а)");
        }
    }

    @Override
    public double refuel() {
        double maxFuel = 65;
        return maxFuel;
    }
}
