package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.holotova.hw4.Task4;

class Task4Test {

    @Test
    void creatingArray () {
        int numbers[] = new int[2000];
        Assertions.assertNotNull(numbers);
        Assertions.assertEquals(2000, numbers.length);
    }
    @Test
    void changeEvenElementsArray () {
        int[] array = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(new int[]{1, 0, 3, 0, 5, 0}, Task4.changeEven(array));

    }
}