/*2. Заполнить одномерный массив случайными целочисленными значениями. Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.
3. Заполнить одномерный массив случайными целочисленными значениями. Проверить сколько составных чисел присутствует в массиве. Размер массива 1000 элементов.*/

package selfEducation.lesson4;

import java.util.Arrays;

public class Lesson4_2 {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println(Arrays.toString(fillArray(array)));
        System.out.println(countPrimeComposite(array));

    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 10 + 1));
        }
        return array;
    }

    public static String countPrimeComposite(int[] array) {
        int prime = 0;
        int composite = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                boolean isPrime = true;
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    prime++;
                } else {
                    composite++;
                }
            }
        }
        return "Простых чисел " + prime + " Составных чисел " + composite;
    }

}
