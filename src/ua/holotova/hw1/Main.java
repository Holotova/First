package ua.holotova.hw1;

public class Main {
    public static void main(String[] args) {
        String firstName = "Svetlana", lastName = "Holotova";
        System.out.println(firstName + " " + lastName);
        int nameLength = firstName.length();
        if (nameLength < 7) {
            System.out.println("less than 7");
        } else {
            System.out.println("more than 7");
        }
        for (int x = 0, y = 5; x <= 10; x++) {
            System.out.println("Шаг " + x + ", значение " + y);
            y = y + 2;
        }

    }
}

