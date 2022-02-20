/*2) Создать дочерний класс passenger car
        - добавить поле класс passenger
        - добавить метод посадить пассажира (в машине не может быть более 3 пассажиров)*/
package ua.holotova.hw10;

public class PassengerCar extends Car implements Recovery {

    Passenger passenger;
    int numberOfPassengers;

    public PassengerCar(int series, int year, String color, int fuel) {
        super(series, year, color, fuel);
        passenger = new Passenger(numberOfPassengers);

    }

    public String putPassengerOn() {
        return passenger.calcPassengers(3) + "passenger(s) in the car";
    }

    @Override
    public void refuel() {
        super.refuel();
    }

    public class Passenger {
        private int numberOfPassengers;

        public Passenger(int numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
        }

        public int calcPassengers(int numberOfPassengers) {
            if (numberOfPassengers <= 3) {
                return numberOfPassengers;
            } else {
                return 3;
            }
        }
    }
}
