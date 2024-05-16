package List.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import List.List;
import org.junit.jupiter.api.Test;

public class ArrayListTest_enduf7686 {

    @Test
    void ArrayList의_생성_및_초기화() {
        // 구현 후 수정
        List<Integer> list = new ArrayList_enduf7686<Integer>();

        assertThat(list).isNotNull();
    }

    @Test
    void 데이터_5개_저장() {
        // 구현 후 수정
        List<Integer> list = new ArrayList_enduf7686<Integer>();

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
        // 구현 후 수정
        List<Integer> list = new ArrayList_enduf7686<Integer>();

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

    @Test
    void 데이터_5개_저장_후_데이터_확인() {
        // 구현 후 수정
        List<Integer> list = new ArrayList_enduf7686<Integer>();

        list.insert(11);
        list.insert(11);
        list.insert(22);
        list.insert(22);
        list.insert(33);

        assertThat(list.contains(11)).isEqualTo(true);
        assertThat(list.contains(12)).isEqualTo(false);
        assertThat(list.contains(22)).isEqualTo(true);
        assertThat(list.contains(33)).isEqualTo(true);
        assertThat(list.contains(34)).isEqualTo(false);
    }
}