package ua.holotova.hw15.task1;

import java.util.Optional;

public class MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    int size = 0;

    public MyList() {
        head = new MyNode<>(null, tail, null);
        tail = new MyNode<>(null, null, head);
    }

    public void add(E value) {
        MyNode<E> newNode = tail;
        newNode.setValue(value);
        tail = new MyNode<>(null, null, newNode);
        newNode.setNext(tail);
        size++;
        System.out.print(newNode.getValue());
        System.out.printf(" (List size: %d ) %n", size);
    }

    public Optional<Integer> getFromLast(E value) {
        MyNode<E> target = tail.getPrevious();
        int i;
        for (i = size; i > 0; i--) {
            if (value == target.getValue()) {
                return Optional.of(i - 1);
            } else {
                target = target.getPrevious();
            }
        }
        return Optional.empty();
    }
}
