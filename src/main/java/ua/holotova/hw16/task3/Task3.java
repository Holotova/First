/*Написать итератор по массиву*/
package ua.holotova.hw16.task3;

public class Task3 {
    public static void main(String[] args) {
        String[] array = new String[]{"Zero", "One", "Two", "Three", "Four", "Five"};
        ArrayIterator stringIterator = new ArrayIterator(array);
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }
}
