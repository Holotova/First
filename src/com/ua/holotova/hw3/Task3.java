package com.ua.holotova.hw3;

import java.util.Scanner;

/*Программа "Угадай число"
Отгадать целое число, которое "загадал" компьютер в определенном диапазоне.
Решение. Описание переменных:  secret – число, "загаданное" компьютером; guess – очередное число, вводимое пользователем.
Алгоритм решения задачи: Программа генерирует псевдослучайное число, которое записывается в переменную secret.Пока число secret не совпадет с числом guess, пользователю будет предлагаться ввести очередное число.
При этом, если guess > secret, то на экран будет выдаваться сообщение "Много". Иначе будет проверяться условие guess < secret.При его положительном значении появится сообщение "Мало", иначе сообщение "Угадал".*/
public class Task3 {
    public static void main(String[] args) {
        int from = 0;
        int to = 100;
        GuessNumber(from, to);
    }

    public static void GuessNumber(int from, int to) {
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
