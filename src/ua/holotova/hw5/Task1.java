/*1Заполнение двумерного массива значениями индекса(от 1 и до кол-ва элементов в массиве),при этом каждая вторая строка - отрицательными значениями.Например
        1 2 3
        -4 -5 -6
        7 8 9
        -10 -11 -12
 Передать массив в метод, заполнить данный массив*/
package ua.holotova.hw5;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        int[][] array = new int[m][n];
        for (int i = 0; i < fillArrayNegativeNumbers(array).length; i++) {
            for (int j = 0; j < fillArrayNegativeNumbers(array)[i].length; j++) {
                System.out.print(fillArrayNegativeNumbers(array)[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] fillArrayNegativeNumbers(int[][] array){
        int[][] negativeArray = Arrays.copyOf(array, array.length);
        int s = 1;
        for (int i = 0; i < negativeArray.length; i++) {
            for (int j = 0; j < negativeArray[i].length; j++) {
                negativeArray[i][j] = s++;
                if (i % 2 != 0) {
                    negativeArray[i][j] = -negativeArray[i][j];
                }
            }
        }
        return negativeArray;
    }
}
