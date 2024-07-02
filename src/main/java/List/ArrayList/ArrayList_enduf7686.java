package List.ArrayList;

import static java.lang.System.arraycopy;

import List.List;

public class ArrayList_enduf7686<E> implements List<E> {

    private static final int DEFAULT_INIT_SIZE = 10;

    private Object[] array;
    private int size;

    public ArrayList_enduf7686() {
        this(DEFAULT_INIT_SIZE);
    }

    public ArrayList_enduf7686(int initSize) {
        this.array = new Object[initSize];
        this.size = 0;
    }

    @Override
    public void insert(E data) {
        array[size++] = data;

        if (array.length == size) {
            Object[] temp = array.clone();

            array = new Object[size + DEFAULT_INIT_SIZE];
            arraycopy(temp, 0, array, 0, temp.length);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        for (int i = 0; i <= size; i++) {
            if (o.equals(array[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E temp = (E) array[index];

        for (int idx = index + 1; idx < array.length; idx++) {
            array[idx - 1] = array[idx];
        }
        array[--size] = null;

        return temp;
    }
}
