package List.LinkedList;

import static id.ID.name;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import List.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest_name {

    private final LinkedListFactory<Integer> factory = new LinkedListFactory<>();
    private List<Integer> list;

    @BeforeEach
    void init() {
        //깃허브 아이디 입력하면 각자 만든 리스트 객체 생성
        list = factory.createList(name);
    }

    @Test
    void LinkedList의_생성_및_초기화() {
        assertThat(list).isNotNull();
    }

    @Test
    void 데이터_5개_저장() {
        list.insert(11);
        list.insert(11);
        list.insert(22);
        list.insert(22);
        list.insert(33);

        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(0)).isEqualTo(11);
        assertThat(list.get(1)).isEqualTo(11);
        assertThat(list.get(2)).isEqualTo(22);
        assertThat(list.get(3)).isEqualTo(22);
        assertThat(list.get(4)).isEqualTo(33);
    }


    @Test
    void 데이터_5개_저장_후_22인_데이터_모두_삭제() {
        list.insert(11);
        list.insert(11);
        list.insert(22);
        list.insert(22);
        list.insert(33);

        // Iterable을 구현하면 enhanced for loop를 사용할 수 있습니다.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 22) {
                list.remove(i);
                i--; // 삭제되면 index가 조정되므로 해당 index부터 다시 확인해야 합니다.
            }
        }

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(11);
        assertThat(list.get(1)).isEqualTo(11);
        assertThat(list.get(2)).isEqualTo(33);
    }
}