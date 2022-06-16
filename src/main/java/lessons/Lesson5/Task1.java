
package lessons.Lesson5;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        fillRandArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("min: " + findMinElement(numbers));
        System.out.println("min element index: " + findMinElementIndex(numbers));
        System.out.println("max: " + findMaxElement(numbers));
        System.out.println("max: element index: " + findMaxElementIndex(numbers));
        System.out.println("middle: " + findMiddleElement(numbers));
        System.out.println("is array unique: " + isValuesUnique(numbers));
    }

    private static void fillRandArray(int[] array) {
        Random random = new Random();
        random.nextInt(1000);
        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt(1000);
        }
    }

    private static void checkArray(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Empty array");
        }
    }

    private static int findMinElement(int[] numbers) {
        checkArray(numbers);
        int min = numbers[0];
        for (int number : numbers) {
            if (min > number) {
                min = number;
            }
        }
        return min;
    }

    private static int findMaxElement(int[] numbers) {
        checkArray(numbers);
        int max = numbers[0];
        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    private static int findMiddleElement(int[] numbers) {
        checkArray(numbers);
        int n = numbers.length / 2;
        return numbers[n];
    }

    private static int findMaxElementIndex(int[] numbers) {
        int max = findMaxElement(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == max) {
                return i;
            }
        }
        return -1;
    }

    private static int findMinElementIndex(int[] numbers) {
        int min = findMinElement(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == min) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValuesUnique(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;

    }
}
