import java.util.HashMap;
import java.util.Map;

public class Namesakes {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Trump", "Donald");
        map.put("John", "Ivanka");
        map.put("O'brain", "Walter");
        map.put("Dod", "Silvester");
        map.put("Stallone", "Silvester");
        map.put("Page", "Toby");
        map.put("Page", "Happy");
        map.put("Danin", "Page");
        map.put("Hendrix", "Donald");
        map.put("Bahman", "John");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
