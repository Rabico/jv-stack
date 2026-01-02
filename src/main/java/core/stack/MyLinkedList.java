package core.stack;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int arrSize = 0;

    public void add(T value) {
        Node<T> node = new Node(null, value, null);
        if (arrSize == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        arrSize += 1;
    }

    public void add(T value, int index) {
        checkBoundries(index, arrSize);
        if (arrSize == index) {
            add(value);
        } else if (index == 0) {
            head = new Node<>(null, value, head);
            head.next.prev = head;
            arrSize += 1;
        } else {
            Node<T> oldNode = findNode(index);
            Node<T> newNode = new Node<>(oldNode.prev, value, oldNode);
            if (oldNode.prev != null) {
                oldNode.prev.next = newNode;
            }
            newNode.next.prev = newNode;
            arrSize += 1;
        }

    }


    public T get(int index) {
        checkBoundries(index, arrSize - 1);
        Node<T> oldNode = findNode(index);
        return oldNode.item;
    }

    public T remove(int index) {
        checkBoundries(index, arrSize - 1);
        Node<T> oldNode = findNode(index);
        unlike(oldNode, index);
        return oldNode.item;
    }

    public int size() {
        return arrSize;
    }

    public boolean isEmpty() {
        return arrSize == 0;
    }

    private void checkBoundries(int index, int bound) throws IndexOutOfBoundsException {
        if (index < 0 || index > bound) {
            throw new IndexOutOfBoundsException("Index is out of boundries");
        }
    }

    private void unlike(Node<T> node, int index) {
        if (arrSize == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == arrSize - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        arrSize -= 1;
    }

    private Node findNode(int index) {
        Node<T> oldNode;
        if (index < arrSize / 2) {
            oldNode = head;
            for (int i = 0; i < index; i++) {
                oldNode = oldNode.next;
            }
        } else {
            oldNode = tail;
            for (int j = 0; j < arrSize - index - 1; j++) {
                oldNode = oldNode.prev;
            }
        }
        return oldNode;
    }

    class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T item;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

    }
}

