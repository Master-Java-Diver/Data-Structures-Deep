package Stack;

import java.util.EmptyStackException;

public class Stack_array_hellomatia<E> implements Stack<E> {
    private static final int INITIAL_CAPACITY = 10;
    private E[] array;
    private int size;
    private int maxCapacity;

    @SuppressWarnings("unchecked")
    public Stack_array_hellomatia() {
        array = (E[]) new Object[INITIAL_CAPACITY];
        this.maxCapacity = INITIAL_CAPACITY;
    }

    @Override
    public void push(E item) {
        if (isNull(item)) {
            throw new NullPointerException("Can not push null to the stack");
        }
        if (isFull()) {
            resize();
        }
        array[size()] = item;
        ++size;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top()];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[size() - 1];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int search(E item) {
        for (int index = 0; index < size(); ++index) {
            if (array[index].equals(item)) {
                return index;
            }
        }
        return -1;
    }

    private boolean isNull(E item) {
        return item == null;
    }

    private int top() {
        --size;
        return size;
    }

    private boolean isFull() {
        if (size() == Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        }
        return maxCapacity == size();
    }

    private void resize() {
        maxCapacity = maxCapacity << 1;
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[maxCapacity];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}
