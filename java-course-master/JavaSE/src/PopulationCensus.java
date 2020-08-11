import java.util.HashMap;
import java.util.Map;

public class PopulationCensus {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Trump", "Donald");
        map.put("John", "Ivanka");
        map.put("O'brain", "Walter");
        map.put("Dod", "Silvester");
        map.put("Stallone", "Silvester");
        map.put("Page", "Toby");
        map.put("Quin", "Happy");
        map.put("Danin", "Page");
        map.put("Hendrix", "Richy");
        map.put("Bahman", "John");

        return map;


    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.values()) {
            if (s.equals(name))
                count ++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.keySet()) {
            if (s.equals(lastName))
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
