import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ExpressedInShort {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
        {
            //String s = reader.readLine();
            //list.add(s);
            strings.add(reader.readLine());
        }

        int min = strings.get(0).length();
        for(int i = 1; i < strings.size(); i++) {
            if(strings.get(i).length() < min) {
                min = strings.get(i).length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == min)
                System.out.println(strings.get(i));
        }
    }
}
