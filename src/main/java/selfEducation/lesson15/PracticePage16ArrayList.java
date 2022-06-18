package selfEducation.lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PracticePage16ArrayList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        System.out.println(fillList(numbers));
        System.out.println("sum: " + getSum(numbers));
        System.out.println("Odd List " + getOddNumber(numbers));
        System.out.println("String List " + convertToStringList(numbers));
        System.out.println("Double String List " + doubling(convertToStringList(numbers)));

    }

    private static List<Integer> fillList(List<Integer> numbers) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            numbers.add(random.nextInt(10));
        }
        return numbers;
    }

    private static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> getOddNumber(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>(numbers.size());
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }

    private static List<String> convertToStringList(List<Integer> numbers) {
        List<String> stringList = new ArrayList<>(numbers.size());
        for (Integer number : numbers) {
            stringList.add(number.toString());
        }
        return stringList;
    }

    private static List<String> doubling(List<String> strings) {
        List<String> doubleStringList = new ArrayList<>(strings.size());
        for (String string : strings) {
            doubleStringList.add(string + string);
        }
        return doubleStringList;
    }

}
