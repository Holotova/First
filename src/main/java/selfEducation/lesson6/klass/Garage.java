package selfEducation.lesson6.klass;

public class Garage {
    public static void checkCar (Car car){
        if (car.petrol < 100){
            if (car.engine < 200){
                System.out.println("мало бензина и не хватает мощности двигателя");
            } else {
                System.out.println("Мощность двигателя нормальная, недостаточно топлива!");
            }
        } else if (car.engine < 200){
            System.out.println("Топлива достаточно, не хватает мощности двигателя!");
        } else {
            System.out.println("Проверка пройдена! Достаточно топлива и мощности двигателя!");
        }
    }
}
