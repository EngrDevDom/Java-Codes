import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CutAndPaste {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>(5);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            strings.add(reader.readLine());
        String s;
        for (int i = 0; i < 13; i++) {
            s = strings.get(strings.size()-1);
            strings.remove(strings.size()-1);
            strings.add(0,s);
        }
        for (int i = 0; i < strings.size(); i++)
            System.out.println( strings.get(i) );
    }
}
