package ua.holotova.hw14;

import java.util.List;

public class Util<M> implements Multiplier<M> {
    public M value;

    public void printHashCode(M value) {
        System.out.println("HashCode: " + value.hashCode());
    }

    public void save(M value) {
        this.value = value;
    }

    public M get() {
        return value;
    }

    @Override
    public Number[] doubleValueIn(Number[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].intValue() * array[i].intValue();
        }
        return array;
    }

    public <S extends Number> void sum(Number one, Number two) { // should work only with numbers
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

}
