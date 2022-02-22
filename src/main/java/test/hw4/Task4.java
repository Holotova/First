/*Заполнить одномерный массив случайными целочисленными значениями. Все четные значения заменить на нули. Размер массива - 2000 элементов.*/

package test.hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[2000];
        fillArray(numbers);
        System.out.println(Arrays.toString((numbers)));
        System.out.println(Arrays.toString((changeEven(numbers))));
    }

    private static void fillArray(int[] filledArray) {
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = 1 + (int) (Math.random() * 10);
        }
    }

    public static int[] changeEven(int[] numbers){
        int[] changedArray = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i<changedArray.length; i++){
            if (changedArray[i] % 2 == 0 ){
                changedArray[i] = 0;
            }
        }
        return changedArray;
    }
}
