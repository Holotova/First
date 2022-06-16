/*
1. Удалить из строки пробелы и определить, является ли она перевертышем. Считать строку из консоли. Передать в метод, который удалит из нее все пробелы.
После этого определить, является ли она палиндромом (перевертышем), т.е. одинаково пишется как с начала, так и с конца.

2. Количество слов в строке. Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.
Требования к задачам: Считывание данных проводить с консоли в методе main(). Все расчеты проводить в отдельных методах и возвращать значение,
которое выводится в консоль в методе main().
Метод возвращает значение строки с удаленными пробелами, а другой метод определяет является ли строка палиндромом и возвращает boolean значение
*/
package selfEducation.lesson3;

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        System.out.println("Введите предложение с пробелами: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        if (isPalindrom(text) == true) {
            System.out.println("Это палиндром");
        } else {
            System.out.println("Не палиндром");
        }
        System.out.println("Количество слов в предложении: " + countWords(text));
    }

    public static String deleteSpaces(String text) {
        String mono = text.replaceAll(" ", "");
        return mono;
    }

    public static boolean isPalindrom(String text) {
        StringBuffer buffer = new StringBuffer(deleteSpaces(text));
        String reversed = String.valueOf(buffer.reverse());
        boolean isPalindrom = reversed.equals(deleteSpaces(text));
        return isPalindrom;
    }

    public static int countWords (String text){
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' '){
                words++;
            }
        }
        words++;
        return words;
    }
}
