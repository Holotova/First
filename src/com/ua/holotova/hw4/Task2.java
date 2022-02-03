/*Заполнить одномерный массив случайными целочисленными значениями. Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.*/
package com.ua.holotova.hw4;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] firstArray = new int[1000];
        fillArray(firstArray);
    }

    public static void fillArray(int[] firstArray) {
        int[] secondArray = Arrays.copyOf(firstArray, firstArray.length);
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = 1 + (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(secondArray));
        int primeNumbers = 0;
        int compositeNumbers = 0;
        for (int i = 0; i < secondArray.length; i++) {
            if (secondArray[i] != 1) {
                boolean isPrime = true;
                for (int j = 2; j < secondArray[i]; j++) {
                    if (secondArray[i] % j == 0) {
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
        System.out.println("Простых чисел " + primeNumbers);
        System.out.println("Составных чисел " + compositeNumbers);
    }
}






