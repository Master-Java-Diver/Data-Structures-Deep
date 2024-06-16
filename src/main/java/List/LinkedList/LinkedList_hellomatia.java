package List.LinkedList;

import List.List;

public class LinkedList_hellomatia<E> implements List<E> {
    private final Node head;
    private Node tail;
    private int size;

    public LinkedList_hellomatia() {
        this.head = new Node(null);
        this.tail = head;
    }

    @Override
    public void insert(E data) {
        tail.setNext(createNode(data));
        tail = tail.getNext();
        size++;
    }

    private Node createNode(E data) {
        return new Node(data);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E o) {
        for (Node now = head.getNext(); now != null; now = now.getNext()) {
            if (now.getData().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).getData();
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node removeNode = getNode(index);
        Node prevNode = getNode(index - 1);
        if (removeNode == tail) {
            prevNode.setNext(null);
            tail = prevNode;
        } else {
            prevNode.setNext(removeNode.getNext());
        }
        removeNode.setNext(null);
        size--;
        return removeNode.getData();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index) {
        Node now = head.getNext();
        for (int i = 0; i < index; i++) {
            now = now.getNext();
        }
        return now;
    }

    public int search(E data) {
        int index = 0;
        for (Node now = head.getNext(); now != null; now = now.getNext()) {
            if (now.getData().equals(data)) {
                return index;
            }
            ++index;
        }
        return -1;
    }

    private class Node {
        private final E data;
        private Node next;

        protected Node(E data) {
            this.data = data;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private E getData() {
            return data;
        }
    }
}
