package ua.holotova.hw12;

import java.util.Optional;

public class Task4 {
    public static void main(String[] args) {
        PhoneBook.PHONE_BOOK[0] = "016/161616";
        PhoneBook.PHONE_BOOK[1] = "016/161617";
        PhoneBook.PHONE_BOOK[2] = "016/161618";

        Optional<String> s;
        s = findIndexByPhoneNumber("016/161618");
        if (s.isPresent()) {
            System.out.println("Phone was found. Index: " + s.get());
        } else {
            System.out.println("Phone is not exist");
        }
    }

    public static Optional<String> findIndexByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < PhoneBook.PHONE_BOOK.length; i++) {
            if (phoneNumber.equalsIgnoreCase(PhoneBook.PHONE_BOOK[i])) {
                return Optional.of(phoneNumber);
            }
        }
        return Optional.empty();
    }

    class PhoneBook {
        private static final String[] PHONE_BOOK = new String[3];
    }
}

