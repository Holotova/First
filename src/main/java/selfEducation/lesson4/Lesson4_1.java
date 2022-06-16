/*1. Заполнить одномерный массив случайными целочисленными значениями.Найти среднее арифметическое и среднее геометрическое элементов массива. Размер массива - 400 элементов.
        P.S. значения элементов можно ограничить значениями 1-10 включительно.
4. Заполнить одномерный массив случайными целочисленными значениями. Все четные значения заменить на нули. Размер массива - 2000 элементов.
Примечания: Исходные массивы, которые передаются в метод не должны измениться. Вычисления производить в отдельных методах.*/

package selfEducation.lesson4;

import java.util.Arrays;

public class Lesson4_1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 10 + 1));
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Среднее арифметическое равно: " + countAverage(array));
        System.out.println("Среднее геометрическое равно: " + countMean(array));

    }

    public static double countAverage(int[] array) {
        int[] array2 = Arrays.copyOf(array, array.length);
        double sum = 0;
        for (int i = 0; i < array2.length; i++) {
            sum += array2[i];
        }
        double average = sum / array2.length;
        return average;

    }

    public static double countMean(int[] array) {
        int[] array3 = Arrays.copyOf(array, array.length);
        double product = array3[0];
        for (int i = 1; i < array3.length; i++) {
            product *= array3[i];
        }
        double mean = Math.pow(product, 1.0/array3.length);
        return mean;
    }
}
