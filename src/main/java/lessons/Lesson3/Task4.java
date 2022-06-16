package lessons.Lesson3;

public class Task4 {
    public static void main(String[] args) {
        int number = 5558888;
        calcEvenOdd(number);
    }

    private static void calcEvenOdd(int number) {
        int even = 0;
        int odd = 0;
        while (number != 0) {
            if (number % 2 == 0) {
                even++;

            } else {
                odd++;

            }
            number /= 10;

        }
        System.out.println(even);
        System.out.println(odd);


    }
}
