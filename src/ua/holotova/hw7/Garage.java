package ua.holotova.hw7;

public class Garage {
    public static void checkСar(Car o){
        String a = o.petrol > 50? o.engine >200? "Проверка пройдена": "Недостаточная мощность двигателя!": o.engine >200? "Недостаточно топлива!":"Недостаточно топлива и низкая мощность двигателя!";
        System.out.println(a);
    }
}
