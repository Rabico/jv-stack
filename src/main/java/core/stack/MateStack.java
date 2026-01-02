package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    private int size = 0;

    public void push(T value) {
        list.add(value);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return list.get(size - 1);
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        return list.remove(size);
    }

    public int size() {
        return size;
    }
}
