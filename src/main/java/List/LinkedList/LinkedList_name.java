package List.LinkedList;

import List.List;
import java.util.LinkedList;

public class LinkedList_name<E> implements List<E> {

    //구현시 삭제
    private final java.util.List<E> linkedList;

    public LinkedList_name() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void insert(E data) {
        linkedList.add(data);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(E o) {
        return linkedList.contains(o);
    }

    @Override
    public E get(int index) {
        return linkedList.get(index);
    }

    @Override
    public E remove(int index) {
        return linkedList.remove(index);
    }
}
