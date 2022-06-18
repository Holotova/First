/*2.	Проверить, заданный массив на упорядоченность по невозрастанию, т. е. определить, верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
        *передать массив в метод, получить boolean*/

package selfEducation.lesson5;

import java.util.Arrays;

public class Lesson5_2 {
    public static void main(String[] args) {
        int[] array = {10, 8, 7, 6, 5, 4};
        System.out.println(Arrays.toString(array));
        if (isDecrease(array) == true){
            System.out.println("Массив упорядочен по невозрастанию");
        } else {
            System.out.println("Массив не упорядочен по невозрастанию");
        }
    }
    public static boolean isDecrease (int[] array){
        boolean isDecrease = true;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i+1] > array[i]){
                isDecrease = false;
            }
        }
        return isDecrease;
    }
}
