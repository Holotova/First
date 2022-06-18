/*package ua.holotova.lesson12;

import java.util.Random;

public class Lesson12 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i <= 20; i++) {
            int x = random.nextInt(10);
            System.out.println("number" + x);
            System.out.println("Status Code" + getStatusCode(x));
            System.out.println("Special Object " + getSpecialObject(x));
            System.out.println("Exception " + getException(x));
            System.out.println("Exit  " + getExit(x));

        }
    }

    public static int getStatusCode(int x) {
        return x >= 5 ? -1 : 1;
    }

    public static Object getSpecialObject(int x) {
        if (x >=5){
            *//*return new SpecialObject(1, )*//*
        }
    }


    public static String getException(int x) throws IllegalAccessException {
        if (x >=5){
            throw new IllegalAccessException("Number is more than 5");
        }
    }

    public static int getExit(int x) {
    if (x >=5){
        System.exit(x);
    }
    }
    record Specialobject
}*/




