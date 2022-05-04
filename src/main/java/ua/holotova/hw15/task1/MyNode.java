package ua.holotova.hw15.task1;

public class MyNode<E> {
    private E value;
    private MyNode<E> next;
    private MyNode<E> previous;

    public MyNode(E value, MyNode<E> next, MyNode<E> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public MyNode<E> getNext() {
        return next;
    }

    public void setNext(MyNode<E> next) {
        this.next = next;
    }

    public MyNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(MyNode<E> previous) {
        this.previous = previous;
    }
}
