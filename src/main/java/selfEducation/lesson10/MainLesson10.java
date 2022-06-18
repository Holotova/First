package selfEducation.lesson10;

public class MainLesson10 {
    public static void main(String[] args) {
        Car car = new Car(3000, 2020, "Red", 23);
        PassengerCar passengerCar = new PassengerCar(0007, 2022, "Green", 20.5);
        Track track = new Track(1010, 2021, "Black", 50);

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
