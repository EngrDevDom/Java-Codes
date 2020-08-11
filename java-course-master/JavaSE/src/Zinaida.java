import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Zinaida {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        map.put("Сталлоне2", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("FEBRUARY 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            HashMap.Entry<String, Date> s = iterator.next();
            if(s.getValue().getMonth() > 4 & s.getValue().getMonth() < 8){
                iterator.remove();
            }
        }
/*
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(pair.getValue());
            if (calendar.get(Calendar.MONTH) > 5 && calendar.get(Calendar.MONTH) < 9)
                map.remove(pair.getKey());

        }
*/


    }

    public static void main(String[] args) {

    }
}
