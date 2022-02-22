/*Заполнить одномерный массив случайными целочисленными значениями. Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.*/
package test.hw4;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] firstArray = new int[1000];
        fillArray(firstArray);
        System.out.println(Arrays.toString(firstArray));
        System.out.println(countPrimeComp(firstArray));
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + (int) (Math.random() * 10);
        }
    }

    public static String countPrimeComp(int[] firstArray) {
        int primeNumbers = 0;
        int compositeNumbers = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != 1) {
                boolean isPrime = true;
                for (int j = 2; j < firstArray[i]; j++) {
                    if (firstArray[i] % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    primeNumbers++;
                } else {
                    compositeNumbers++;
                }
            }
        }
        return "Простых чисел " + primeNumbers + ", Составных чисел " + compositeNumbers;
    }
}






