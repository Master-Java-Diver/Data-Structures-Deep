package Stack;

import List.LinkedList.LinkedList_hellomatia;

import java.util.EmptyStackException;

public class Stack_list_hellomatia<E> implements Stack<E> {
    private final LinkedList_hellomatia<E> list;

    public Stack_list_hellomatia() {
        list = new LinkedList_hellomatia<>();
    }

    @Override
    public void push(E item) {
        if (isNull(item)) {
            throw new NullPointerException("Can not push null to the stack");
        }
        validateSize();
        list.insert(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = list.get(top());
        list.remove(top());
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(top());
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int search(E item) {
        return list.search(item);
    }

    private boolean isNull(E item) {
        return item == null;
    }

    private int top() {
        return size() - 1;
    }

    private void validateSize() {
        if (size() == Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        }
    }
}
