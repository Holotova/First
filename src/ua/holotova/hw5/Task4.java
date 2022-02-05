/*Удаление из массива k-го элемента со сдвигом всех расположенных справа от него элементов на одну позицию влево.
 *Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода. Изначальный массив не должен измениться*/
package ua.holotova.hw5;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int k = 3;
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Массив после удаления " + k + "-го элемента: " + Arrays.toString(cutArray(array, k)));
    }

    public static int[] cutArray(int[] array, int k) {
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = new int[array2.length - 1];
        System.arraycopy(array2, 0, array3, 0, k);
        System.arraycopy(array2, k + 1, array3, k, array2.length - k - 1);
        return array3;
    }
}
