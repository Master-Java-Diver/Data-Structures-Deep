package List.LinkedList;

import static id.ID.hellomatia;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import List.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private final LinkedListFactory<Integer> factory = new LinkedListFactory<>();
    private List<Integer> list;

    @BeforeEach
    void init() {
        list = factory.createList(hellomatia);
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
    void 데이터_중복_저장_후_모두_포함여부_확인() {
        list.insert(11);
        list.insert(11);
        list.insert(22);
        list.insert(22);
        list.insert(33);

        assertThat(list.contains(11)).isTrue();
        assertThat(list.contains(22)).isTrue();
        assertThat(list.contains(33)).isTrue();
    }

    @Test
    void 비어있는_리스트_확인() {
        assertThat(list.isEmpty()).isTrue();
        list.insert(10);
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    void 데이터_삽입_후_크기_확인() {
        assertThat(list.size()).isEqualTo(0);
        list.insert(10);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void 유효하지_않은_인덱스로_데이터_가져오기() {
        assertThatThrownBy(() -> list.get(0)).isInstanceOf(IndexOutOfBoundsException.class);
        list.insert(10);
        assertThatThrownBy(() -> list.get(-1)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> list.get(2)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 유효하지_않은_인덱스로_데이터_삭제() {
        assertThatThrownBy(() -> list.remove(0)).isInstanceOf(IndexOutOfBoundsException.class);
        list.insert(10);
        assertThatThrownBy(() -> list.remove(-1)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> list.remove(2)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 모든_데이터_삭제_후_리스트_비우기() {
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.remove(0);
        list.remove(0);
        list.remove(0);

        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void 데이터_삽입_및_삭제_반복() {
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.remove(1);
        list.insert(50);

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(10);
        assertThat(list.get(1)).isEqualTo(30);
        assertThat(list.get(2)).isEqualTo(40);
        assertThat(list.get(3)).isEqualTo(50);
    }

    @Test
    void 리스트의_중간에_데이터_삽입() {
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.remove(1);
        list.insert(25);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(10);
        assertThat(list.get(1)).isEqualTo(30);
        assertThat(list.get(2)).isEqualTo(25);
    }

    @Test
    void 데이터_5개_삽입_후_모두_삭제() {
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        for (int i = 0; i < 5; i++) {
            list.remove(0);
        }

        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();
    }
}