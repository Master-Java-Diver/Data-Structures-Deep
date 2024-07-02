package List.LinkedList;

import List.List;

public class LinkedList_enduf7686<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size;

    @Override
    public void insert(E data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            tail.next = new Node<>(data);
            tail.next.prev = tail;
            tail = tail.next;
        }

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null && size == 0;
    }

    @Override
    public boolean contains(E o) {
        Node<E> node = head;

        while (node != null) {
            if (node.value.equals(o)) {
                return true;
            }

            node = node.next;
        }

        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.value;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        size--;

        if (size == 0) {
            head = null;
            tail = null;
        }

        return node.value;
    }

    private static class Node<E> {

        private E value;

        private Node<E> prev;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }
}
