package Stack;

@SuppressWarnings("rawtypes")
public class StackImpl_array_name<E> implements Stack<E> {

    // 구현 시 삭제
    private final java.util.Stack<E> stack = new java.util.Stack<>();

    @Override
    public void push(E item) {

        stack.push(item);
    }

    @Override
    public E pop() {
        return stack.pop();
    }

    @Override
    public E peek() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public int search(E item) {
        return stack.search(item);
    }

    public void resize() {
        // 용량이 꽉 찬 경우

        // 용량이 부족한 경우
    }

}
