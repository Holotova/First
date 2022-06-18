/*Отгадать целое число, которое "загадал" компьютер в определенном диапазоне.
Описание переменных:
secret – число, "загаданное" компьютером;
guess – очередное число, вводимое пользователем.
Алгоритм решения задачи:
Программа генерирует псевдослучайное число, которое записывается в переменную secret.
Пока число secret не совпадет с числом guess, пользователю будет предлагаться ввести очередное число.
При этом, если guess > secret, то на экран будет выдаваться сообщение "Много". Иначе будет проверяться условие guess < secret.
При его положительном значении появится сообщение "Мало", иначе сообщение "Угадал".*/

package selfEducation.lesson3;

import java.util.Scanner;

public class Lesson3_1 {
    public static void main(String[] args) {
        int secret = (int) (Math.random() * 101);
        System.out.println("secret = " + secret);
        System.out.println("Введите число от 0 до 100:");
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        while (secret != guess) {
            if (guess > secret) {
                System.out.println("Много, введите число поменьше:");
            } else {
                System.out.println("Мало, введите число побольше: ");
            }
            guess = scanner.nextInt();
        }
        System.out.println("Угадал!");
    }
}
