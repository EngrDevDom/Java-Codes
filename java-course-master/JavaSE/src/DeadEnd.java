import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DeadEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();

        for (; true; )     //while (true)
        {
            String s = reader.readLine();
            if (s.equals("end"))
                break;
            strings.add(s);
        }

        for (int i = 0; i < strings.size(); i ++)
            System.out.println(strings.get(i));
    }
}
