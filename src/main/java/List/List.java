package List;

public interface List<E> {

    void insert(E data);

    int size();

    boolean isEmpty();

    boolean contains(E o);

    E get(int index);

    E remove(int index);
}
