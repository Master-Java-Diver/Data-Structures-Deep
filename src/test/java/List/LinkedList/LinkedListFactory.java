package List.LinkedList;

import static org.reflections.scanners.Scanners.SubTypes;

import List.List;
import id.ID;
import java.lang.reflect.InvocationTargetException;
import org.reflections.Reflections;

public class LinkedListFactory<E> {

    @SuppressWarnings("unchecked")
    public List<E> createList(ID id) {
        Reflections reflections = new Reflections("List.LinkedList", SubTypes.filterResultsBy(s -> true));

        Class<? extends List> clazz = reflections.getSubTypesOf(List.class).stream()
                .filter(list -> list.getSimpleName().equals("LinkedList_" + id.name()))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        try {
            return (List<E>) Class.forName(clazz.getCanonicalName()).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
