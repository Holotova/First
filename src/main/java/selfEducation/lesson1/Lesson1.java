package selfEducation.lesson1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        String name = "Svetlana";
        String surname = " Holotova ";

        System.out.println(name + surname + date);


        if (name.length() > 7) {
            System.out.println("more than 7");
        } else {
            System.out.println("less than 7");
        }
        int j = 5;
        for (int i = 0; i <= 10; i++) {
            System.out.println("Шаг " + i + ", значение " + j);
            j = j + 2;
        }
        reverseNumber();

    }
    public static void reverseNumber (){
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String reversed = "";
        for (int i = 0; i < number.length(); i++){
            reversed = number.charAt(i) + reversed;
        }
        System.out.println("Вы ввели число " + number + ". Перевернутое число получили " + reversed);

    }
}
