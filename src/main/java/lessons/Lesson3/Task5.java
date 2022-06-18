package lessons.Lesson3;/*написать метод, который возводит число в степень. Не использовать класс Math*/

public class Task5 {
    public static void main(String[] args) {
        System.out.println(degree(2, 4));

    }
    public static int degree(int num, int deg){
        if (deg ==0) {
            return 1;
        }
        int result =num;
        for(int i = 2; i <=deg; i++) {
            result *= num;
        }
        return result;
    }
}
