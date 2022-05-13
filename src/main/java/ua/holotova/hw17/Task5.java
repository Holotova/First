/*
Спроектировать обьект Box который содержит коллекцию Item и поле size. Item должен содержать поле name и cost
        a.	Создать коллекцию Box и инициализировать ее 10 коробками
        b.	Спроектировать Предикат, который случайным образом будет выбирать фильтр по размеру допустимых коробок из промежутка min size <= лимит <= max size (создать функ. интерфейс)
        c.	Применить фильтр к коллекции коробок,
        d.	У оставшихся коробок взять колеекции Item
        e.	Отсортировать по цене
        f.	Вывести результат в консоль
*/
package ua.holotova.hw17;

import java.util.*;
import java.util.function.Predicate;

public class Task5 {
    public static void main(String[] args) {
        Map<String, Double> item = new LinkedHashMap<>();
        item.put("white box", 5.5);
        item.put("black box", 10.2);
        item.put("green box", 7.4);
        item.put("red box", 15.8);
        item.put("blue box", 3.1);

        List<Box> boxes = new LinkedList<>();
        boxes.add(new Box(item, 10));
        boxes.add(new Box(item, 11));
        boxes.add(new Box(item, 12));
        boxes.add(new Box(item, 13));
        boxes.add(new Box(item, 14));
        boxes.add(new Box(item, 15));
        boxes.add(new Box(item, 16));
        boxes.add(new Box(item, 17));
        boxes.add(new Box(item, 18));
        boxes.add(new Box(item, 19));

        List<Integer> boxSize = new ArrayList<>();
        for (Box box : boxes) {
            boxSize.add(box.getSize());
        }
        Optional<Integer> minSize = boxSize.stream()
                .min(Integer::compareTo);

        Optional<Integer> maxSize = boxSize.stream()
                .max(Integer::compareTo);

        Random random = new Random();
        int limit = random.nextInt(minSize.get(), maxSize.get());
        Predicate<Box> sizeFilter = x -> x.getSize() <= limit;

        boxes.stream()
                .filter(sizeFilter)
                .map(Box::getItem)
                .flatMap(x -> x.values().stream())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}


