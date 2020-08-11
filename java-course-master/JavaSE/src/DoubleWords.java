import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DoubleWords {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (String string : result)
            System.out.println(string);

    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < list.size(); i ++) {

            temp.add(list.get(i));
            temp.add(list.get(i));

        }
        return temp;
    }
}
