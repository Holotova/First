package ua.holotova.hw25.service;

import ua.holotova.hw25.dao.StudentDao;
import ua.holotova.hw25.model.Student;
import ua.holotova.hw25.model.UniversityGroup;

import java.util.*;

public class StudentService {
    private final static StudentDao studentDao = new StudentDao();

    private static final Random RANDOM = new Random();

    public void addStudents(UniversityGroup group, int count) {
        Set<Student> studentSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Student student = new Student("Student-" + RANDOM.nextInt(0, 1000));
            student.setGroupSet(Collections.singleton(group));
            studentSet.add(student);
        }
        group.setStudents(studentSet);
    }

    public void printStudentInfo(Integer id) {
        List<Object[]> studentInfo = studentDao.getStudentInfoById(id);
        for (Object[] objects : studentInfo) {
            System.out.printf("Student with ID %d:\n Name - %s, Croup: %s, Curator: %s, University: %s. \n",
                    id, objects[0], objects[1], objects[2], objects[3]);
        }
    }
}



