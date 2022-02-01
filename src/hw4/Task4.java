/*Заполнить одномерный массив случайными целочисленными значениями. Все четные значения заменить на нули. Размер массива - 2000 элементов.*/

package hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[2000];
        fillArray(numbers);
    }
    public static void fillArray(int[] numbers) {
        int[] filledArray = new int[numbers.length];
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = 1 + (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString((filledArray)));
        for (int i = 0; i<filledArray.length; i++){
            if (filledArray[i] % 2 == 0 ){
                filledArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString((filledArray)));
    }
}
