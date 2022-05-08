/*На вход подается строка текста. Постройте частотный словарь слов (где ключ это слово, а значение - кол-во повторений).
Данные нужно получить в отсортированном виде по значению.*/

package ua.holotova.hw16;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите текст");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split("\\s+");
        for (Map.Entry entry : countWords(words).entrySet()) {
            System.out.println(entry);
        }
        sortOnValue(countWords(words));
    }

    private static HashMap<String, Integer> countWords(String[] words) {
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }
        return wordCounter;
    }

    private static void sortOnValue(HashMap<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
