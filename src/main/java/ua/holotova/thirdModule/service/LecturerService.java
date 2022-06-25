package ua.holotova.thirdModule.service;

import ua.holotova.thirdModule.dao.LecturerDao;
import ua.holotova.thirdModule.model.Lecturer;

import javax.persistence.NoResultException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LecturerService {
    private static final Random RANDOM = new Random();
    private static final LecturerDao LECTURER_DAO = new LecturerDao();
    private static final Scanner SCANNER = new Scanner(System.in);


    public List<Lecturer> createLecturers() {
        final Lecturer lecturer1 = new Lecturer("William", "Stevenson",
                RANDOM.nextInt(30, 60));
        final Lecturer lecturer2 = new Lecturer("Nicholas", "Morales",
                RANDOM.nextInt(30, 60));
        final Lecturer lecturer3 = new Lecturer("Linda", "Gordon",
                RANDOM.nextInt(30, 60));
        return Arrays.asList(lecturer1, lecturer2, lecturer3);
    }

    public void printLecturerByFirstOrLastName() {
        try {
            System.out.println("Please enter first name or last name of lecturer ");
            String name = SCANNER.nextLine();
            Lecturer lecturer = LECTURER_DAO.getLecturerByFirstOrLastName(name);
            System.out.printf("The Lecturer with the name/lastname %s:\n%s\n", name, lecturer.toString());
        } catch (NoResultException e) {
            System.out.println("Lecturer with such name/lastname not found");
        }
    }
}

