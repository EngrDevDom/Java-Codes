import java.util.HashMap;
import java.util.Map;

public class MapCollectionofObject {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        //напишите тут ваш код
        for (Map.Entry<String, Object> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Object value = pair.getValue();                  //значение
            System.out.println(key + " - " + value);
        }
    }
}
