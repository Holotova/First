/*2) Создать дочерний класс passenger car
        - добавить поле класс passenger
        - добавить метод посадить пассажира (в машине не может быть более 3 пассажиров)*/
package ua.holotova.hw10;

public class PassengerCar extends Car implements Recovery {

    Passenger passenger;

    public PassengerCar(int series, int year, String color, int fuel) {
        super(series, year, color, fuel);

    }

    public static String putPassengerOn(int numberOfPassengers) {
        if (numberOfPassengers <= 3) {
            return numberOfPassengers + " passenger(s) in the car";
        } else {
            return "3 passenger(s) in the car";
        }
    }

    @Override
    public void refuel() {
        super.refuel();
    }

    public class Passenger {
    }
}
