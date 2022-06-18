package selfEducation.lesson10;

public class Track extends Car implements Recovery {
    double cargo;

    public Track(int serialNumber, int year, String color, double fuel) {
        super(serialNumber, year, color, fuel);
    }

    public void loadCargo(double cargo) {
        double loadCapacity = 20;
        double loadedCargo = 0;
        double unloadedCargo = 0;
        if (cargo > 0) {
            if (cargo > loadCapacity) {
                loadedCargo = loadCapacity;
            } else {
                loadedCargo += cargo;
            }
            System.out.println("Загружено " + loadedCargo + " т груза");
        }
        if (cargo < 0) {
            unloadedCargo -= cargo;
            System.out.println("Выгружено " + unloadedCargo + " т груза");
        }
    }

    @Override
    public void run(int distance) {
        double fuelConsumption = 0.2;
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
    public double refuel() {
        double maxFuel = 600;
        return maxFuel;
    }
}
