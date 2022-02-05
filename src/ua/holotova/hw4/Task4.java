/*Заполнить одномерный массив случайными целочисленными значениями. Все четные значения заменить на нули. Размер массива - 2000 элементов.*/

package ua.holotova.hw4;

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

    private static int[] changeEven(int[] numbers){
        for (int i = 0; i<numbers.length; i++){
            if (numbers[i] % 2 == 0 ){
                numbers[i] = 0;
            }
        }
        return numbers;
    }
}
