/*4. Заполнить одномерный массив случайными целочисленными значениями. Все четные значения заменить на нули. Размер массива - 2000 элементов.*/
package selfEducation.lesson4;

import java.util.Arrays;

public class Lesson4_3 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        System.out.println(Arrays.toString(fillArray(array)));
        System.out.println(Arrays.toString(replaceEven(array)));
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
        }
        return array;
    }

    public static int[] replaceEven(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] % 2 == 0) {
                newArray[i] = 0;
            }
        }
        return newArray;
    }
}
