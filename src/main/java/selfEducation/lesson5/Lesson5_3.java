/*3.	Дан двумерный массив NxN(количество строк = количество столбцов), написать программу которая поменяет местами столбцы и строки.
 *Необходимо создать новый массив, в котором выполняются превращения и вернуть его из метода. Изначальный массив не должен измениться*/
package selfEducation.lesson5;

public class Lesson5_3 {
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] array = new int[m][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(fillArray(array)[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(reverseArray(array, m, n)[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static int[][] fillArray(int[][] array) {
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i % 2 == 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    public static int[][] reverseArray(int[][] array, int m, int n) {
        int[][] newArray = new int[m][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[j][i] = array[i][j];
            }
        }
        return newArray;
    }
}
