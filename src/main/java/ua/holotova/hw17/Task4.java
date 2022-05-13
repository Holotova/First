/*Задан список случайных чисел, с фомощью функции reduce найти минимальное число*/
package ua.holotova.hw17;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 9, 15, 33, -20, 88, 47, 0, -100, -99);
        Optional<Integer> minNumber = numbers.stream()
                .reduce(Integer::min);
        System.out.println("Минимальное число: " + minNumber.get());
    }
}
