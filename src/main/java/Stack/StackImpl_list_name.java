package Stack;

@SuppressWarnings("rawtypes")
public class StackImpl_list_name<E> implements Stack<E> {

    // 구현 시 삭제
    private final java.util.Stack<Object> stack = new java.util.Stack<>();

    private static class Node<E> {

    }

    @Override
    public void push(E item) {
        stack.push(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() {
        return (E) stack.pop();
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        return (E) stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

}
