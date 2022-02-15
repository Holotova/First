package ua.holotova.hw9;

import java.util.Random;

public class GetRandomNumber {
    public Integer get(Random random) {
        int number = random.nextInt(100);
        if (number == 0) {
            return -1;
        }

        if (number < 10) {
               return -10;
           }

           if (number < 20) {
               return number / 5;
           }

           if (number < 50) {
               return null;
           }

           if (number < 80) {
               return 1000 / number;
           }

           return number;
    }
}