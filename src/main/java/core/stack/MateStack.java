package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private Node<T> tail = new Node<>(null, null);
    private int arrSize = 0;

    public void push(T value) {
        if (arrSize == 0) {
            tail.item = value;
        } else {
            tail = new Node<>(tail, value);
        }
        arrSize++;
    }

    public T peek() {
        if (arrSize == 0) {
            throw new EmptyStackException();
        }
        return tail.item;
    }

    public T pop() {
        if (arrSize == 0) {
            throw new EmptyStackException();
        }
        arrSize--;
        T value = tail.item;
        tail = tail.prev;
        return value;
    }

    public int size() {

        return arrSize;
    }

    class Node<T> {
        private Node<T> prev;
        private T item;

        public Node(Node<T> prev, T item) {
            this.prev = prev;
            this.item = item;
        }

    }
}
