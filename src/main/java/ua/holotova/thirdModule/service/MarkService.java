package ua.holotova.thirdModule.service;

import ua.holotova.thirdModule.model.Mark;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MarkService {
    final static Random RANDOM = new Random();

    public Set<Mark> createMarks() {
        Set<Mark> marks = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Integer value = RANDOM.nextInt(1, 12);
            Mark mark = new Mark(value);
            marks.add(mark);
        }
        return marks;
    }

}
