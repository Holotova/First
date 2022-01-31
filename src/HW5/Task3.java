/*Дан двумерный массив NxN(количество строк = количество столбцов), написать программу которая поменяет местами столбцы и строки.
 *Необходимо создать новый массив, в котором выполняются превращения и вернуть его из метода. Изначальный массив не должен измениться*/
package HW5;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println(" ");
        reverseArray(array);
    }

    public static void reverseArray(int[][] array) {
        int[][] array2 = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array2[j][i] = array[i][j];
            }
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.println(Arrays.toString(array2[i]));
        }
    }
}
