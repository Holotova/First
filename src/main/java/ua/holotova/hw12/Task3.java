package ua.holotova.hw12;

public class Task3 {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (MyException1 | MyException2 | MyException3 e) {
            System.out.println("ERROR");
        }
    }

    public static void throwException() {
        try {
            throw new MyException1("Exception 1");
        } catch (MyException1 e) {
            throw new MyException2("Exception 2");
        } catch (MyException2 e) {
            throw new MyException3("Exception 3");
        }
    }
}
