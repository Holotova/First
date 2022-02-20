/*Создать класс car (будет служить родительским)
        - с полями: серия, год, цвет, топливо
        - с методами:
        I) движение (движется пока есть топливо),
        II) метод показать статистику
        - добавить конструктор на 4 поля
        5) Имплементировать интерфейс в созданных ранее типах машин*/

package ua.holotova.hw10;

public class Car implements Recovery {
    int series;
    int year;
    String color;
    int fuel;

    public Car(int series, int year, String color, int fuel) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
    }

    public void run() {
        while (fuel > 0) {
            System.out.println("Car is running");
        }
        System.out.println("Fuel is over");
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

    @Override
    public void refuel() {
        Recovery.super.refuel();
    }

    public static void main(String[] args) {
        PassengerCar car1 = new PassengerCar(2, 2009, "white", 30);
        Track car2 = new Track(3, 2010, "green", 10);
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car1.putPassengerOn());
        System.out.println(car2.loadCargo(100));

    }

}
