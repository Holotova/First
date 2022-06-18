package selfEducation.lesson17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(item -> System.out.println(item));

        List<String> colors = Arrays.asList("Black", "White", "Red");
        Collections.sort(colors, (o1, o2) -> {
            String o1LastLetter = o1.substring(o1.length() - 1);
            String o2LastLetter = o2.substring(o2.length() - 1);
            return o1LastLetter.compareTo(o2LastLetter);
        });

        final double currency = 100.2;
        List<Double> price1 = Arrays.asList(25.2, 50.6, 80.2, 60.0, 90.9);
        List<Double> priceMore60 = price1.stream()
                .filter(p -> p >= 60)
                .map(p -> p / currency)
                .collect(Collectors.toList());

        System.out.println(priceMore60);
    }


}
