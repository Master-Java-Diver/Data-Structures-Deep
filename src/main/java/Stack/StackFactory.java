package Stack;

public class StackFactory {
    // 자기 클래스 명으로 변경
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Stack<Integer> createStack_arr() {
        return new StackImpl_array_name();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Stack<Integer> createStack_list() {
        return new StackImpl_list_name();
    }
}