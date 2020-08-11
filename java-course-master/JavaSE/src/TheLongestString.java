import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TheLongestString {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
        {
            //String s = reader.readLine();
            //list.add(s);
            strings.add(reader.readLine());
        }

        int max = strings.get(0).length();
        for(int i = 1; i < strings.size(); i++) {
            if(strings.get(i).length() > max) {
                max = strings.get(i).length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == max)
                System.out.println(strings.get(i));
        }
    }
}
