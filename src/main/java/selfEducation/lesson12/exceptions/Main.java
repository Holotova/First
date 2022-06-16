package selfEducation.lesson12.exceptions;

public class Main {
    public static void main(String[] args) throws MyException1 {
        try {
            getException1(6);
        } catch (MyException1 e){
            e.printStackTrace();
        } finally {
            System.out.println("Проверяемое исключение с метода 1");
        }

        getException2(6);

    }

    public static void getException1 (int number) throws MyException1 {
        if (number >= 8){
            throw new MyException1();
        }
        System.out.println(number);
    }

    public static void getException2 (int number){
        if (number <= 7){
            throw new MyException2();
        }
        System.out.println(number);
    }
}
