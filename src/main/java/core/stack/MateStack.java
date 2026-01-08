package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> top;
    private int size = 0;

    public void push(T value) {
        if (size == 0) {
            top = new Node<>(null, value);
        } else {
            top = new Node<>(top, value);
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        T value = top.value;
        top = top.prev;
        return value;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private Node<T> prev;
        private T value;

        private Node(Node<T> prev, T value) {
            this.prev = prev;
            this.value = value;
        }

    }
}
