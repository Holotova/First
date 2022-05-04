package ua.holotova.hw12;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int number = getRandomNumber();
        try {
            if (number < 0) {
                throw new Exception("Negative number");
            } else {
                System.out.println(number);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + number);
        } finally {
            System.out.println("Finally block");
        }
    }

    private static int getRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(-50, 50);
        return number;
    }

}
