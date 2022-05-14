package ua.holotova.hw16.task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator implements Iterator<String> {
    private String[] array;
    private int arrayIndex;

    public ArrayIterator(String[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return arrayIndex < array.length;
    }

    @Override
    public String next() {
        if (arrayIndex < array.length) {
            return array[arrayIndex++];
        }
        throw new NoSuchElementException("No such element");
    }
}
