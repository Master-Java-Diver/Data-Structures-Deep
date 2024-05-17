package List.ArrayList;

import List.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArrayListTest_hellomatia {


    @TestFactory
    @SuppressWarnings("unchecked")
    Collection<DynamicTest> testAllArrayLists() throws Exception {
        java.util.List<DynamicTest> dynamicTests = new ArrayList<>();

        String packageName = "List.ArrayList";

        Set<Class<?>> annotatedClasses = findClassesWithAnnotation(packageName);

        for (Class<?> clazz : annotatedClasses) {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            dynamicTests.add(DynamicTest.dynamicTest(clazz.getSimpleName() + " - ArrayList의 생성 및 초기화",
                    () -> testArrayListCreation((List<Integer>) constructor.newInstance())));

            dynamicTests.add(DynamicTest.dynamicTest(clazz.getSimpleName() + " - 데이터 5개 저장",
                    () -> testArrayListInsertion((List<Integer>) constructor.newInstance())));

            dynamicTests.add(DynamicTest.dynamicTest(clazz.getSimpleName() + " - 데이터 5개 저장 후 22인 데이터 모두 삭제",
                    () -> testArrayListDeletion((List<Integer>) constructor.newInstance())));
        }

        return dynamicTests;
    }

    private Set<Class<?>> findClassesWithAnnotation(String packageName) {
        Reflections reflections = new Reflections(packageName, Scanners.TypesAnnotated);
        return reflections.getTypesAnnotatedWith(JavaDiverCustomArrayList.class);
    }

    private void testArrayListCreation(List<Integer> list) {
        assertThat(list).isNotNull();
    }

    private void testArrayListInsertion(List<Integer> list) {
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

    private void testArrayListDeletion(List<Integer> list) {
        list.insert(11);
        list.insert(11);
        list.insert(22);
        list.insert(22);
        list.insert(33);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 22) {
                list.remove(i);
                i--;
            }
        }

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(11);
        assertThat(list.get(1)).isEqualTo(11);
        assertThat(list.get(2)).isEqualTo(33);
    }
}