package selfEducation.lesson12.optional;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        Optional<Integer> opt;
        try {
            opt = filterNumber();
            if (opt.isPresent()) {
                System.out.println(opt.get());
            } else {
                System.out.println("No number");
            }
        } catch (IOException e) {
            opt = filterNumber();
            if (opt.isPresent()) {
                System.out.println(opt.get());
            } else {
                System.out.println("No number");
            }
        }
    }

    private static Optional<Integer> filterNumber() throws IOException {
        Random random = new Random();
        int number = random.nextInt(0, 100);
        System.out.println(number);
        if (number < 20) {
            return Optional.of(number);
        }
        if (number < 50) {
            throw new IOException(String.valueOf(number));
        }
        if (number < 70) {
            return Optional.empty();
        }
        return Optional.of(number);
    }
}
