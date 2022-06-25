package ua.holotova.thirdModule;

import ua.holotova.thirdModule.config.HibernateFactoryUtil;
import ua.holotova.thirdModule.service.*;

import java.util.Scanner;

public class Main {
    private static final UniversityManagementSystemService MANAGEMENT_SYSTEM_SERVICE =
            new UniversityManagementSystemService();
    private static final StudyGroupService STUDY_GROUP_SERVICE = new StudyGroupService();
    private static final LecturerService LECTURER_SERVICE = new LecturerService();
    private static final UniversitySubjectService UNIVERSITY_SUBJECT_SERVICE = new UniversitySubjectService();
    private static final LearnerService LEARNER_SERVICE = new LearnerService();

    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        MANAGEMENT_SYSTEM_SERVICE.createUniversitySystem();
        System.out.printf("Welcome to Information Center of %s!\n",
                UniversityManagementSystemService.createUniversity().getName());
        System.out.println("To get the information you need please  enter number:\n");
        Scanner scanner = new Scanner(System.in);
        int enteredNumber = 0;

        while (enteredNumber != 7) {
            System.out.println("1. To find group by part of name enter 1");
            System.out.println("2. To find number of students in each group enter 2");
            System.out.println("3. To find average marks in each group enter 3");
            System.out.println("4. To find information about lecturer by first name or lastname enter 4");
            System.out.println("5. To find subjects with the worst and the best percentage enter 5");
            System.out.println("6. To find students with a certain advancement enter 6");
            System.out.println("7. To exit enter 7");

            try {
                enteredNumber = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data!");
            }

            switch (enteredNumber) {
                case 1 -> STUDY_GROUP_SERVICE.printGroupsByNamePart();
                case 2 -> STUDY_GROUP_SERVICE.printQtyStudentsInGroups();
                case 3 -> STUDY_GROUP_SERVICE.printAverageMarksInGroups();
                case 4 -> LECTURER_SERVICE.printLecturerByFirstOrLastName();
                case 5 -> UNIVERSITY_SUBJECT_SERVICE.printBestWorstPercentageSubject();
                case 6 -> LEARNER_SERVICE.printLearnersWithAdvancementMore();
                case 7 -> System.out.println("Thank you for attention. Good Buy!");
                default -> System.out.println("Enter correct number please");
            }
            System.out.println("_____________________________");
        }
    }
}
