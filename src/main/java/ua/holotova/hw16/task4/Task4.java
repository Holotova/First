package ua.holotova.hw16.task4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Student student1 = new Student("Bob", 1, 1);
        Student student2 = new Student("Sam", 2, 1);
        Student student3 = new Student("Lily", 3, 1);
        Student student4 = new Student("Kate", 1, 1);
        Student student5 = new Student("Polly", 2, 1);
        Student student6 = new Student("Robby", 3, 1);
        Student student7 = new Student("Kelly", 1, 1);
        Student student8 = new Student("Ann", 2, 1);
        Student student9 = new Student("Alex", 3, 1);
        Student student10 = new Student("Kerry", 1, 1);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);

        printStudents(students, 1);

        List<Student> secondCourseStudents = selectGoodStudents(students);
        printStudents(secondCourseStudents, 2);
        System.out.println(students.size() - secondCourseStudents.size() + " students were expelled");

        List<Student> thirdCourseStudents = selectGoodStudents(secondCourseStudents);
        printStudents(thirdCourseStudents, 3);
        System.out.println(secondCourseStudents.size() - thirdCourseStudents.size() + " students were expelled");

        List<Student> fourthCourseStudents = selectGoodStudents(thirdCourseStudents);
        printStudents(fourthCourseStudents, 4);
        System.out.println(thirdCourseStudents.size() - fourthCourseStudents.size() + " students were expelled");

        List<Student> fifthCourseStudents = selectGoodStudents(fourthCourseStudents);
        printStudents(fifthCourseStudents, 5);
        System.out.println(fourthCourseStudents.size() - fifthCourseStudents.size() + " students were expelled");

        List<Student> sixthCourseStudents = selectGoodStudents(fifthCourseStudents);
        printStudents(sixthCourseStudents, 6);
        System.out.println(fifthCourseStudents.size() - sixthCourseStudents.size() + " students were expelled");

        List<Student> graduates = selectGoodStudents(sixthCourseStudents);
        for (Student st : graduates) {
            System.out.println("Students graduated: " + st);
        }
        System.out.println(sixthCourseStudents.size() - graduates.size() + " students were expelled");
    }

    private static List<Student> selectGoodStudents(List<Student> students) {
        List<Student> nextCourseStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.countAverageMark(student.getMarks()) >= 3) {
                nextCourseStudents.add(student);
            }
        }
        return nextCourseStudents;
    }

    private static void printStudents(List<Student> students, int course) {
        System.out.print("Students of the " + course + " course: ");
        for (Student st : students) {
            System.out.print(st);
        }
        System.out.println();
    }

}

