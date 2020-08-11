import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RichGuysOnly {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Trump", 500);
        map.put("John", 300);
        map.put("O'brain", 1000);
        map.put("Dod", 501);
        map.put("Stallone", 750);
        map.put("Page", 400);
        map.put("Quin", 990);
        map.put("Danin", 100);
        map.put("Hendrix", 800);
        map.put("Bahman", 666);

        return map;

    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, Integer> s = iterator.next();
            if (s.getValue() < 500)
                iterator.remove();

        }
    }

    public static void main(String[] args) {

    }
}
