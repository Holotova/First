package ua.holotova.hw9;

import java.util.Random;

public class Training {
    public static void main(String[] args) {

        System.out.println(fillRandom());

    }
        public static  Integer fillRandom() {
            Random random = new Random();
           final int number = random.nextInt(100);
            System.out.println(number);
            if (number < 10) {
                return -10;
            }

            if (number < 20) {
                return number / 5;
            }

            if (number < 50) {
                return 0; // нельзя вернуть null, так как метод требует возврат значения типа Integer
            }

            if (number < 80) {
                return 1000 / number;
            }

            return number;
        }
    }


