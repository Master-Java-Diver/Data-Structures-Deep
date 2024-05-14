package List.ArrayList;

import List.List;

import java.util.ArrayList;

public class ArrayList_name<E> implements List<E> {

    // 구현시 삭제
    private final java.util.List<E> arrayList;

    public ArrayList_name() {
        this.arrayList = new ArrayList<>();
    }

    @Override
    public void insert(E data) {
        arrayList.add(data);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean contains(E o) {
        return arrayList.contains(o);
    }

    @Override
    public E get(int index) {
        return arrayList.get(index);
    }

    @Override
    public E remove(int index) {
        return arrayList.remove(index);
    }
}
