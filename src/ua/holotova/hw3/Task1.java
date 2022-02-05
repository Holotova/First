package ua.holotova.hw3;
/*
Удалить из строки пробелы и определить, является ли она перевертышем
 Считать строку из консоли.
 Передать в метод, который удалит из нее все пробелы.
 После этого определить, является ли она палиндромом (перевертышем), т.е. одинаково пишется как с начала, так и с конца.
 Метод возвращает значение строки с удаленными пробелами, а другой метод определяет является ли строка палиндромом и возвращает boolean значение
*/

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        isPalindrome(text);
    }

    public static String removeSpace(String text) {
        String x = text.replace(" ", "");
        return x;
    }

    public static void isPalindrome(String x) {
        StringBuilder strBuilder = new StringBuilder(removeSpace(x));
        String rev = strBuilder.reverse().toString();
        if (removeSpace(x).equalsIgnoreCase(rev)) {
            System.out.println("Палиндром");
        } else {
            System.out.println("Не палиндром");
        }

    }
}


