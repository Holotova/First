/*Доп задание:
        4.	Удаление из массива k-го элемента со сдвигом всех расположенных справа от него элементов на одну позицию влево.
        *Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода. Изначальный массив не должен измениться*/
package selfEducation.lesson5;

import java.util.Arrays;

public class Lesson5_4 {
    public static void main(String[] args) {
        int k = 3;
        int[] array = new int[10];
        System.out.println(Arrays.toString(fillArray(array)));
        System.out.println(Arrays.toString(cutArray(array, k)));
    }
    public static int[] fillArray (int[] array){
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = num++;
        }
        return array;
    }
    public static int[] cutArray (int[] array, int k){
        int[] newArray = Arrays.copyOf(fillArray(array), fillArray(array).length);
        int[] cutArray = Arrays.copyOf(newArray, newArray.length-1);
        System.arraycopy(newArray, 0, cutArray, 0, k-1 );
        System.arraycopy(newArray, k+1, cutArray, k, cutArray.length-k);
        return cutArray;
    }
}

