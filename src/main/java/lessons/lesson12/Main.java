/*Написать метод, который генерирует случайное число 0 - 100ю
        Если значение в пределах 0-20 - то вернуть его (в Optional
        Если значение в пределах 20-50 - кинуть исключение
        Если значение в пределах 50-70 - вернуть пустой Optional создать пустым
        Если значение в пределах 70-100 - вернуть его
        В случае исключения нужно запросить значение еще раз в блоке catch
         достать значение и напечатать в консольб если оно есть*/

package lessons.lesson12;

import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> x;
        try {
            x = method1();
            if (x.isPresent()){
                System.out.println(x.get());
            }else{
                System.out.println("null");
            }
           } catch (RuntimeException e) {
        }
    }

    private static Optional<Integer> method1() {
        Random random = new Random();
        int number = random.nextInt(0, 100);
        if (number < 20) {
            return Optional.of(number);
        } else if (number < 50) {
            throw new RuntimeException();
        } else if (number < 70) {
            return Optional.empty();
        } else {
            return Optional.of(number);
        }

    }
}
