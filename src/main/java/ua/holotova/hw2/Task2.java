package ua.holotova.hw2;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(getArea(2, 2, 3, 5, 6, 1));
    }

    public static double getArea(double x1, double y1, double x2, double y2, double x3, double y3) {


        double s = 0.5 * (((x1 - x3) * (y2 - y3)) - ((x2 - x3) * (y1 - y3)));
        return Math.abs(s);

    }

}
