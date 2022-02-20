/*3) Создать дочерний класс truck
        - добавить поле cargo
        - добавить метод погрузки и выгрузки груза
        - переопределить метод движения (потребления топлива х2 от нормы)
*/

package ua.holotova.hw10;

public class Track extends Car implements Recovery {

   int cargo;

    public Track(int series, int year, String color, int fuel) {
        super(series, year, color, fuel);
    }


    public static String loadCargo(int cargo) {
        if (cargo > 0) {
            return "Cargo is loaded";
        }
        return "Cargo is unloaded";
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Fuel consumption is 2 times higher than normal");
    }

    @Override
    public void refuel() {
        super.refuel();
    }
}
