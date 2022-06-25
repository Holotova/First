package ua.holotova.thirdModule.service;

import ua.holotova.thirdModule.dao.LearnerDao;
import ua.holotova.thirdModule.model.Learner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LearnerService {
    private final static LearnerDao LEARNER_DAO = new LearnerDao();
    private final static Scanner SCANNER = new Scanner(System.in);

    public List<Learner> createLearnerForGroup1() {
        Learner l1 = new Learner("Denise", "Smith", 19,
                LocalDate.of(2020, 8, 12));
        Learner l2 = new Learner("Regina", "Patterson", 18,
                LocalDate.of(2020, 8, 9));
        Learner l3 = new Learner("Edith", "Martin", 20,
                LocalDate.of(2020, 8, 24));
        Learner l4 = new Learner("Ashley", "Waters", 25,
                LocalDate.of(2020, 7, 8));
        return Arrays.asList(l1, l2, l3, l4);

    }

    public List<Learner> createLearnerForGroup2() {
        Learner l5 = new Learner("Charles", "Brown", 30,
                LocalDate.of(2020, 6, 4));
        Learner l6 = new Learner("Tony", "Moreno", 21,
                LocalDate.of(2020, 7, 4));
        Learner l7 = new Learner("Alberto", "Newman", 23,
                LocalDate.of(2020, 8, 1));
        Learner l8 = new Learner("Leona", "Graham", 20,
                LocalDate.of(2020, 9, 1));
        Learner l9 = new Learner("Mildred", "Moore", 30,
                LocalDate.of(2020, 6, 2));
        return Arrays.asList(l5, l6, l7, l8, l9);
    }

    public List<Learner> createLearnerForGroup3() {
        Learner l10 = new Learner("Matthew", "Barnett", 29,
                LocalDate.of(2020, 6, 12));
        Learner l11 = new Learner("Melanie", "Armstrong", 21,
                LocalDate.of(2020, 6, 22));
        Learner l12 = new Learner("Michael", "Rogers", 38,
                LocalDate.of(2020, 9, 12));
        Learner l13 = new Learner("Albert", "Green", 23,
                LocalDate.of(2020, 8, 5));
        Learner l14 = new Learner("Deanna", "Lopez", 18,
                LocalDate.of(2020, 7, 22));
        Learner l15 = new Learner("Linda", "Gordon", 23,
                LocalDate.of(2020, 8, 30));
        return Arrays.asList(l10, l11, l12, l13, l14, l15);
    }

    public void printLearnersWithAdvancementMore() {
        System.out.println("Please enter the minimal value of advancement of student you would like to see");
        Integer advancementRateLimit = null;
        try {
            advancementRateLimit = Integer.parseInt(SCANNER.next());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect data!");
        }
        List<Object[]> learners = LEARNER_DAO.getLearnersWithAdvancementMore(advancementRateLimit);
        if (learners.size() != 0) {
            System.out.printf("Students with advancement more %d:\n", advancementRateLimit);
            for (Object[] object : learners) {
                System.out.printf("%s %s, rate of advancement: %.2f\n", object[0], object[1], object[2]);
            }
        } else {
            System.out.println("Any Student with such advancement found");
        }

    }
}
