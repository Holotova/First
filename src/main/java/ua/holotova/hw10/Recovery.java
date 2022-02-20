//4) Создать интерфейс Recovery с методом refuel (восстанавливает топливо машины до полного значения)
package ua.holotova.hw10;

public interface Recovery {
    public default void refuel() {
        System.out.println("Уровень топлива восстановлен");
    }
}
