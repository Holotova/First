package ua.holotova.hw25.service;

import ua.holotova.hw25.dao.CourseDao;
import ua.holotova.hw25.model.Course;
import ua.holotova.hw25.model.Student;

import java.util.*;

public class CourseService {
    private static final Random RANDOM = new Random();
    private final CourseDao courseDao = new CourseDao();


    public void setCourse(Student student, int courseCount) {
        Set<Course> courses = new HashSet<>();
        for (int i = 0; i < courseCount; i++) {
            final Course course = new Course("Course - " + RANDOM.nextInt(0, 1000),
                    RANDOM.nextInt(0, 10));
            course.setStudentSet(Collections.singleton(student));
            courses.add(course);
        }
        student.setCourseSet(courses);
    }

    public void printCoursesByDifficulty(Integer diffFrom, Integer diffTo) {
        List<Course> courses;
        courses = courseDao.getCoursesByDifficulty(diffFrom, diffTo);
        System.out.printf("Courses with difficulty from %d to %d:\n", diffFrom, diffTo);
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
