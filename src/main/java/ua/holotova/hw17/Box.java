package ua.holotova.hw17;

import java.util.Map;

public class Box {
    Map<String, Double> item;
    Integer size;

    public Box(Map<String, Double> item, Integer size) {
        this.item = item;
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public Map<String, Double> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                ", size=" + size +
                '}';
    }
}
