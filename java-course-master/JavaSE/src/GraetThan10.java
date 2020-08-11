import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraetThan10 {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 20; i ++)
            set.add(i);
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        Integer a;
        while (iterator.hasNext()) {
            a = iterator.next();
            if (a.compareTo(10) > 0) iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
