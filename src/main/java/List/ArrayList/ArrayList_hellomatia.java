package List.ArrayList;

import List.List;

@JavaDiverCustomArrayList
public class ArrayList_hellomatia<E> implements List<E> {

    private static final int INITIAL_CAPACITY = 10;
    private E[] array;
    private int size;
    private int maxCapacity;

    @SuppressWarnings("unchecked")
    public ArrayList_hellomatia() {
        this.array = (E[]) new Object[INITIAL_CAPACITY];
        maxCapacity = array.length;
    }

    @Override
    public void insert(E data) {
        if (size() == maxCapacity) {
            maxCapacity = 2 * maxCapacity;
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) new Object[maxCapacity];
            System.arraycopy(array, 0, newArray, 0, size());
            array = newArray;
        }
        array[size()] = data;
        ++size;
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
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E remove(int index) {
        E removed = array[index];
        for (int i = index; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        --size;
        return removed;
    }
}
