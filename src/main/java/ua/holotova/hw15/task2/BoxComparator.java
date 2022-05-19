package ua.holotova.hw15.task2;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box a, Box b) {
        if (a.getVolume() ==0){
            return -1;
        } else if (b.getVolume() ==0){
            return 1;
        } else if (a.getVolume() > b.getVolume()){
            return -1;
        } else if (a.getVolume() < b.getVolume()){
            return 1;
        } else {
            return 0;
        }
    }
}

