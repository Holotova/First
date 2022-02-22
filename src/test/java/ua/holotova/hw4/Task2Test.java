package ua.holotova.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {

    @Test
    void creatingArray () {
        int numbers[] = new int[1000];
        Assertions.assertNotNull(numbers);
        Assertions.assertEquals(1000, numbers.length);
    }
    @Test
    void countPrimeCompositeNumbers () {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertEquals("Простых чисел 4, Составных чисел 5", Task2.countPrimeComp(array));


    }
}