package ua.holotova.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int from = 0;
        int to = 100;
        guessNumber(from, to);
    }

    public static void guessNumber(int from, int to) {
        int secret = from + (int) (Math.random() * to);
        System.out.println(secret); // строка для проверки работоспособности программы
        System.out.println("Введите число от " + from + " до " + to);
        Scanner scan = new Scanner(System.in);
        int guess = scan.nextInt();
        while (secret != guess) {
            if (guess > secret) {
                System.out.println("Много");
            } else {
                System.out.println("Мало");
            }
            System.out.println("Введите число: ");
            guess = scan.nextInt();
        }
        System.out.println("Угадал");
    }
}