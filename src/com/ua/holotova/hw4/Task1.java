/*
Заполнить одномерный массив случайными целочисленными значениями.Найти среднее арифметическое и среднее геометрическое элементов массива. Размер массива - 400 элементов.
P.S. значения элементов можно ограничить значениями 1-10 включительно.
*/
package com.ua.holotova.hw4;
import java.util.Arrays;
public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[400];
        fillArray(numbers);
    }
    public static void fillArray (int[] numbers){
        int[] filledArray = new int[numbers.length];
        for (int i = 0; i < filledArray.length; i++ ) {
            filledArray[i] = 1 + (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(filledArray));
        int[] num = Arrays.copyOf(filledArray, filledArray.length);
        double sum = 0;
        for(int i = 0; i < num.length; i++){
            sum += num[i];
        }
        double average = sum/numbers.length;
        System.out.println("Среднее арифметическое: " + average);
        double product = 1;
        for(int i = 0; i < num.length; i++){
            product *= num[i];
        }
        double mean = Math.pow(product, 1.0/numbers.length);
        System.out.println("Среднее геометрическое: " + mean);
    }
}
