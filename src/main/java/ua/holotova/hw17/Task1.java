/*Задан массив строк. Используя средства StreamAPI отсортировать строки в лексикографическом порядке и вывести в консоль.*/
package ua.holotova.hw17;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Arrays.stream(new String[]{"out", "other", "which", "time", "how", "set", "air", "play", "end"})
                .sorted()
                .forEach(System.out::println);
    }
}
