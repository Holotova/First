/*Проверить, заданный массив на упорядоченность по невозрастанию, т. е. определить, верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
 *передать массив в метод, получить boolean*/
package hw5;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(Arrays.toString(array));
        checkAscending(array);
    }

    public static void checkAscending(int[] array) {
        int[] arrayForCheck = Arrays.copyOf(array, array.length);
        boolean isAscending = true;
        for (int i = 0; i < arrayForCheck.length - 1; i++) {
            if (arrayForCheck[i + 1] < arrayForCheck[i]) {
                isAscending = false;
                break;
            }
        }
        if (isAscending) {
            System.out.println("Массив упорядочен по возрастанию!");
        } else {
            System.out.println("Массив не упорядочен по возрастанию!");
        }
    }
}
