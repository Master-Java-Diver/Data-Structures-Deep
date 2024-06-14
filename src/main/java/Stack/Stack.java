package Stack;

/**
 * 제네릭 스택 인터페이스 정의
 * 
 * @param <E> 스택에 저장될 요소의 타입
 */
public interface Stack<E> {
    /**
     * 스택의 맨 위에 요소를 추가합니다.
     * 
     * @param item 스택에 추가할 요소
     */
    void push(E item);

    /**
     * 스택의 맨 위에 있는 요소를 제거하고 반환합니다.
     * 스택이 비어있을 때 이 메소드를 호출하면 예외가 발생할 수 있습니다.
     * 
     * @return 스택에서 제거된 요소
     */
    E pop();

    /**
     * 스택의 맨 위에 있는 요소를 반환하지만 제거하지는 않습니다.
     * 스택이 비어있을 때 이 메소드를 호출하면 예외가 발생할 수 있습니다.
     * 
     * @return 스택의 맨 위에 있는 요소
     */
    E peek();

    /**
     * 스택이 비어있는지 여부를 반환합니다.
     * 
     * @return 스택이 비어있으면 true, 그렇지 않으면 false
     */
    boolean isEmpty();

    /**
     * 스택에 저장된 요소의 수를 반환합니다.
     * 
     * @return 스택에 있는 요소의 수
     */
    int size();
}