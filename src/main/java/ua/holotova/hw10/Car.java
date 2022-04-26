/*Создать класс car (будет служить родительским)
        - с полями: серия, год, цвет, топливо
        - с методами:
        I) движение (движется пока есть топливо),
        II) метод показать статистику
        - добавить конструктор на 4 поля
        5) Имплементировать интерфейс в созданных ранее типах машин*/

package ua.holotova.hw10;

import selfEducation.lesson10.PassengerCar;
import selfEducation.lesson10.Track;

public class Car {
    int series;
    int year;
    String color;
    double fuel;

    public Car(int series, int year, String color, double fuel) {
        this.series = series;
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
                "series=" + series +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", fuel=" + fuel +
                '}';
    }

    public static void main(String[] args) {
        selfEducation.lesson10.Car car = new selfEducation.lesson10.Car(3000, 2020, "Red", 23);
        selfEducation.lesson10.PassengerCar passengerCar = new PassengerCar(0007, 2022, "Green", 20.5);
        selfEducation.lesson10.Track track = new Track(1010, 2021, "Black", 50);

        car.run(600);
        passengerCar.run(100);
        track.run(1000);

        passengerCar.setPassenger(2);
        track.loadCargo(-10);

        System.out.println("Track - Заправлен полный бак - " + track.refuel() + " л");
        System.out.println("Passenger Car - Заправлен полный бак - " + passengerCar.refuel() + " л");

        System.out.println(car);
        System.out.println(passengerCar);
        System.out.println(track);

    }

}
