package core.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MateStack<T> {
    private LinkedList<T> list = new LinkedList<>();
    private int size = 0;

    public void push(T value) {
        if (!list.contains(value)) {
            list.add(value);
            size++;
        }
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return list.peekLast();
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        return list.removeLast();
    }

    public int size() {
        return size;
    }
}
