package _411_Random_Node;

import java.util.*;

public class RandomCollection<T> {


    List<T> elementList = new ArrayList();
    Map<T, Set<Integer>> valuesToIndices = new HashMap<>();
    Random random = new Random();

    public void add(T item) {

        if (!valuesToIndices.containsKey(item)) {
            valuesToIndices.put(item, new HashSet());
        }
        valuesToIndices.get(item).add(elementList.size());
        elementList.add(item);

        return;
    }

    public boolean remove(T item) {

        if (!valuesToIndices.containsKey(item) || valuesToIndices.get(item).isEmpty()) {
            return false;
        }

        int indexToRemove = valuesToIndices.get(item).iterator().next();
        T itemLast = elementList.get(elementList.size() - 1);

        elementList.set(indexToRemove, itemLast);
        elementList.remove(elementList.size() - 1);

        valuesToIndices.get(item).remove(indexToRemove);

        valuesToIndices.get(itemLast).add(indexToRemove);
        valuesToIndices.get(itemLast).remove(elementList.size());

        return true;
    }

    public boolean contains(T item) {
        return valuesToIndices.containsKey(item) && !valuesToIndices.get(item).isEmpty();
    }

    public T getRandom() {
        if (elementList.isEmpty()) {
            throw new Error("Random collection is empty");
        }
        int index = random.nextInt(elementList.size());
        return elementList.get(index);
    }
}
