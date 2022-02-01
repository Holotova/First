package com.ua.holotova.hw2;

public class Task2MinNum {
    public static void main(String[] args) {

        System.out.println(minNumber(-58, 32.1, -14.5));
    }

    public static double minNumber(double a, double b, double c) {
        a = a >= 0 ? a : -a;
        b = b >= 0 ? b : -b;
        c = c >= 0 ? c : -c;
        double min = a < b ? a < c ? a : c : b < c ? b : c;
        return min;
    }
}
