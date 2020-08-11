import java.util.HashMap;
import java.util.Map;

public class Repetitions {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap <String, String>();

        map.put("Иванов", "Иван");
        map.put("Иванидзе", "Иван");
        map.put("Иваник", "Петр");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидр");
        map.put("Прутков", "Кузьма");
        map.put("Толстой", "Алексей");
        map.put("Тонкий", "Лев");
        map.put("Пушкин", "Михаил");
        map.put("Кукушкин", "Сергей");

        return  map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> name = new HashMap<String, String>(map);
        for(Map.Entry pair : name.entrySet()){
            int count = 0;
            String a = (String) pair.getValue();
            for (Map.Entry pair2 : name.entrySet()) {
                if (pair2.getValue().equals(a))
                    count++;
            }
            if(count > 1){
                for(int i = 0; i < count; i++)
                    removeItemFromMapByValue(map, String.valueOf(a));
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
