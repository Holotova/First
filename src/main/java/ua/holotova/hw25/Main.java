package ua.holotova.hw25;

import ua.holotova.hw25.config.HibernateFactoryUtil;
import ua.holotova.hw25.service.*;

import java.time.LocalDate;

public class Main {
    private static final UniversityService universityService = new UniversityService();
    private static final CourseService courseService = new CourseService();
    private static final CuratorService curatorService = new CuratorService();
    private static final StudentService studentService = new StudentService();
    private static final UniversityGroupService universityGroupService = new UniversityGroupService();


    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        universityService.creatUniversityInfrastructure();
        courseService.printCoursesByDifficulty(5, 8);
        System.out.println("_________");
        curatorService.printCuratorByAgeExperience(LocalDate.of(1990, 1, 1), 5);
        System.out.println("_________");
        universityGroupService.printQtyStudentsByGroup();
        System.out.println("_________");
        studentService.printStudentInfo(3);
        System.out.println("_________");
        universityService.printInfrastructure();
        System.out.println("_________");
    }
}
