package ua.holotova.hw16.task4;

import java.util.*;

public class Student {
    private String name;
    private Integer group;
    private Integer course;
    private Integer[] marks;

    public Student(String name, Integer group, Integer course) {
        this.name = name;
        this.group = group;
        this.course = course;

    }

    public Integer[] getMarks() {
        Integer[] marks = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < marks.length; i++) {
            marks[i] = random.nextInt(1, 6);
        }
        return marks;
    }

    public Double countAverageMark(Integer[] marks) {
        Integer sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        Double average = ((double) sum / marks.length);
        return average;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
