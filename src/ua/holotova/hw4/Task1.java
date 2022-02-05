/*
Заполнить одномерный массив случайными целочисленными значениями.Найти среднее арифметическое и среднее геометрическое элементов массива. Размер массива - 400 элементов.
P.S. значения элементов можно ограничить значениями 1-10 включительно.
*/
package ua.holotova.hw4;
import java.util.Arrays;
public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[400];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Среднее арифметическое: " + countAverage(numbers));
        System.out.println("Среднее геометрическое: " + countMean(numbers));
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + (int) (Math.random() * 10);
        }
    }

    private static double countAverage(int[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = sum / numbers.length;
        return average;
    }

    private static double countMean(int[] numbers) {
        double product = 1;
        for (int i = 0; i < numbers.length; i++) {
            product *= numbers[i];
        }
        double mean = Math.pow(product, 1.0 / numbers.length);
        return mean;
    }
}
