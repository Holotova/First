package ua.holotova.hw31.task2;

import java.util.Scanner;

public class RaceRegistration {
    private final static int LIMIT_OF_RACERS = 10;
    public static int CUSTOM_HORSE_NUMBER;
    public static int HORSES;
    private final Scanner SCANNER = new Scanner(System.in);

    public void chooseNumberOfParticipants() {
        System.out.println("Welcome to our hippodrome!\n" +
                "We invite you to take part in the races!\n");
        do {
            System.out.printf("Please enter the number of racers (from 2 to %d horses):\n", LIMIT_OF_RACERS);
            while (!SCANNER.hasNextInt()) {
                System.out.println("It is not a number!");
                SCANNER.next();
            }
            HORSES = SCANNER.nextInt();
        } while (HORSES <= 1 || HORSES > LIMIT_OF_RACERS);
        System.out.println("Number of participants - " + HORSES);
    }

    public void chooseHorseNumber() {
        do {
            System.out.printf("Choose the horse number you are betting on (from 1 to %d):\n", HORSES);
            while (!SCANNER.hasNextInt()) {
                System.out.println("It is not a number!");
                SCANNER.next();
            }
            CUSTOM_HORSE_NUMBER = SCANNER.nextInt();
        } while (CUSTOM_HORSE_NUMBER <= 0 || CUSTOM_HORSE_NUMBER > HORSES);
        System.out.printf("Your horse number %d. Good Luck!!!\n", CUSTOM_HORSE_NUMBER);
    }
}
