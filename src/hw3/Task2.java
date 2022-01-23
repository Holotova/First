package hw3;
/*Количество слов в строке
        Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.*/

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        countWord(text);
    }

    public static void countWord(String text) {
        int count = 0;
        if (text.length() != 0) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        count++;
        System.out.println("Вы ввели " + count + " слов");
    }

}
