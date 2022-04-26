package ua.holotova.hw12;

import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        f();
    }

    private static void g() throws IOException {
        throw new IOException();
    }

    private static void f() {
        try {
            g();
        } catch (IOException e) {
            throw new RuntimeException("Exception from method f");
        }
    }
}
