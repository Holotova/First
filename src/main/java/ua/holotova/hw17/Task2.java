/*Задан список случайных чисел, отфильтровать числа >= 0 и получить обьект IntSummaryStatistics. Вывести на экране все его показатели*/
package ua.holotova.hw17;

import java.util.IntSummaryStatistics;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        final IntSummaryStatistics intSummaryStatistics = random.ints(20,-100,100)
                .filter(x -> x >= 0)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}
