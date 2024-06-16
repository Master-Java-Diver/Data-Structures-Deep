package Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest_hellomatia {
    private Stack<Integer> stack_arr;
    private Stack<Integer> stack_list;

    @BeforeEach
    void setUp() {
        stack_arr = StackFactory.createStack_arr();
        stack_list = StackFactory.createStack_list();
    }

    @Test
    public void testPushAndPop() {
        stack_arr.push(1);
        assertEquals(1, stack_arr.pop());
        stack_list.push(1);
        assertEquals(1, stack_list.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack_arr.isEmpty());
        assertTrue(stack_list.isEmpty());
        stack_arr.push(1);
        assertFalse(stack_arr.isEmpty());
        stack_list.push(1);
        assertFalse(stack_list.isEmpty());
    }

    @Test
    public void testPeek() {
        stack_arr.push(1);
        stack_arr.push(2);
        assertEquals(2, stack_arr.peek());
        stack_list.push(1);
        stack_list.push(2);
        assertEquals(2, stack_list.peek());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack_arr.size());
        assertEquals(0, stack_list.size());
        stack_arr.push(1);
        stack_arr.push(2);
        assertEquals(2, stack_arr.size());
        stack_list.push(1);
        stack_list.push(2);
        assertEquals(2, stack_list.size());
    }

    // 엣지 케이스 테스트 추가
    @Test
    public void testPopOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack_arr.pop());
        assertThrows(EmptyStackException.class, () -> stack_list.pop());
    }

    @Test
    public void testPeekOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack_arr.peek());
        assertThrows(EmptyStackException.class, () -> stack_list.peek());
    }

    @Test
    public void testPushNull() {
        assertThrows(NullPointerException.class, () -> stack_arr.push(null));
        assertThrows(NullPointerException.class, () -> stack_list.push(null));
    }

    @Test
    public void testPushBeyondMaxSize() {
        try {
            // Integer.MAX_VALUE - 2까지 채우기
            for (int i = 0; i < Integer.MAX_VALUE - 2; i++) {
                stack_arr.push(i);
//                stack_list.push(i);
            }
            // 여기서 한 번 더 push 하려고 할 때
            stack_arr.push(Integer.MAX_VALUE - 1);
//            stack_list.push(Integer.MAX_VALUE - 1);
            // 예외가 발생하지 않으면 테스트 실패
            fail("Should have thrown OutOfMemoryError or similar");
        } catch (OutOfMemoryError e) {
            // 예상되는 예외 처리
            assertTrue(true, "Expected OutOfMemoryError when pushing beyond max size");
        } catch (Exception e) {
            // 다른 예외 발생 시
            fail("Unexpected exception type: " + e);
        }
    }
}