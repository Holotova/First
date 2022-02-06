/*Проверить, заданный массив на упорядоченность по невозрастанию, т. е. определить, верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
 *передать массив в метод, получить boolean*/
package ua.holotova.hw5;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {11, 10, 10, 5, 1, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(checkDescending(array));
    }

    public static boolean checkDescending(int[] array) {
        int[] arrayForCheck = Arrays.copyOf(array, array.length);
        boolean isDescending = true;
        for (int i = 0; i < arrayForCheck.length - 1; i++) {
            if (arrayForCheck[i + 1] > arrayForCheck[i]) {
                isDescending = false;
                break;
            }
        }
        return isDescending;
    }
}
