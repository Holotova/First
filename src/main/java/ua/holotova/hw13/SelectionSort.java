package ua.holotova.hw13;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {8, 15, 7, 4, 8, 12, 0, 9, 15, 20, 3};
        selectionSort(array);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    position = j;
                    min = array[j];
                }
            }
            array[position] = array[i];
            array[i] = min;
        }
        System.out.println(Arrays.toString(array));
    }
}
