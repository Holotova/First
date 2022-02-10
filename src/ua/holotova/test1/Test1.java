/*Пользователь вводит размер массива в консоль  (i >= 10)
        Метод заполняет массив случайными числами в диапазоне [-100; 100]
        Вывести массив на экран
        Пользователю предлагается выбрать способ сортировки по возрастанию или убыванию
        Сортируется массив в соответствии с выбором (нужно написать свой алгоритм сортировки)
        Вывести массив на экран
        Каждое третье число массива возвести в куб
        Вывести массив на экран*/
package ua.holotova.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Укажите размер массива (целое число не менее 10):");
        Scanner scan = new Scanner(System.in);
        int arrLength = scan.nextInt();
        while (arrLength < 10) {
            if (arrLength < 10) {
                System.out.println("Вы ввели слишком маленькое число, повторите попытку:");
            }
            arrLength = scan.nextInt();
        }
        double[] array = new double[arrLength];
        fillRandomArray(array);
        System.out.println(Arrays.toString(array));
        if (chooseSorting() == 1) {
            System.out.println(Arrays.toString(sortArrayAscending(array)));
            System.out.println(Arrays.toString(raiseToPowerAscending(array)));
        } else {
            System.out.println(Arrays.toString(sortArrayDescending(array)));
            System.out.println(Arrays.toString(raiseToPowerDescending(array)));
        }

    }

    public static void fillRandomArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ((Math.random() * 201) - 100);
        }
    }

    public static int chooseSorting() {
        System.out.println("Для сортировки массива по возрастанию введите 1, по убыванию - 0:");
        Scanner scan = new Scanner(System.in);
        int sort = scan.nextInt();
        while ((sort != 0) && (sort != 1)) {
            if (sort != 0) {
                System.out.println("Неверное число, введите 0 или 1:");
            } else if (sort != 1) {
                System.out.println("Неверное число, введите 0 или 1:");
            }
            sort = scan.nextInt();
        }
        return sort;
    }

    public static double[] sortArrayAscending(double[] array) {
        double[] sorted = Arrays.copyOf(array, array.length);
        boolean changed;
        do {
            changed = false;
            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i - 1] > sorted[i]) {
                    double temp = sorted[i - 1];
                    sorted[i - 1] = sorted[i];
                    sorted[i] = temp;
                    changed = true;
                }
            }
        } while (changed);
        return sorted;
    }

    public static double[] sortArrayDescending(double[] array) {
        double[] sorted = Arrays.copyOf(array, array.length);
        boolean changed;
        do {
            changed = false;
            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i - 1] < sorted[i]) {
                    double temp = sorted[i - 1];
                    sorted[i - 1] = sorted[i];
                    sorted[i] = temp;
                    changed = true;
                }
            }
        } while (changed);
        return sorted;
    }

    public static double[] raiseToPowerAscending(double[] array) {
        double[] arrPowerAscending = Arrays.copyOf(sortArrayAscending(array), sortArrayAscending(array).length);
        for (int i = 1; i < arrPowerAscending.length; i++) {
            if (i % 3 == 0) {
                arrPowerAscending[i - 1] = Math.pow(arrPowerAscending[i - 1], 3);
            }
        }
        return arrPowerAscending;
    }

    public static double[] raiseToPowerDescending(double[] array) {
        double[] arrPowerDescending = Arrays.copyOf(sortArrayDescending(array), sortArrayDescending(array).length);
        for (int i = 1; i < arrPowerDescending.length; i++) {
            if (i % 3 == 0) {
                arrPowerDescending[i - 1] = Math.pow(arrPowerDescending[i - 1], 3);
            }
        }
        return arrPowerDescending;
    }
}



