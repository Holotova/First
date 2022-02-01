/*1Заполнение двумерного массива значениями индекса(от 1 и до кол-ва элементов в массиве),при этом каждая вторая строка - отрицательными значениями.Например
        1 2 3
        -4 -5 -6
        7 8 9
        -10 -11 -12
 Передать массив в метод, заполнить данный массив*/
package com.ua.holotova.hw5;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        fillArray(array);
        System.out.println(" ");
        fillArrayNegativeNumbers(array);
    }

    public static void fillArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(10) + 1;
            }
        }
        for (int m = 0; m < array.length; m++) {
            System.out.println(Arrays.toString(array[m]));
        }
    }

    public static void fillArrayNegativeNumbers(int[][] array) {
        int[][] negativeArray = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                negativeArray[i][j] = array[i][j];
                if (i % 2 != 0) {
                    negativeArray[i][j] = -negativeArray[i][j];
                }
            }
        }
        for (int m = 0; m < negativeArray.length; m++) {
            System.out.println(Arrays.toString(negativeArray[m]));
        }
    }
}
