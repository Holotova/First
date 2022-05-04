package ua.holotova.hw15.task2;

import java.util.Comparator;

public class Box implements Comparator<Box> {
    private int volume;

    public Box(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public int compare(Box a, Box b) {
        return 0;
    }
}
