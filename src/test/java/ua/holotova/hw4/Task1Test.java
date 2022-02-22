package ua.holotova.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task1Test {
    private Task1 target;

    @BeforeEach
    void setUp() {
        target = new Task1();
    }


    @Test
    void createArray () {
    int numbers[] = new int[400];
        Assertions.assertNotNull(numbers);
        Assertions.assertEquals(400, numbers.length);
    }
    @Test
    void countAverage_allFine () {
        final double average = Task1.countAverage(new int[]{1, 2, 3, 4});
        Assertions.assertEquals(2.5,average);
    }
    @Test
    void countMean_allFine () {
        final double mean = Task1.countMean(new int[]{1, 2, 3, 4});
        Assertions.assertEquals(2.2133638394006,mean, 1E-10);
    }


}