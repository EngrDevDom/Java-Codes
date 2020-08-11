import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OrderControle {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).length() > list.get(i + 1).length()) {
                System.out.println(i+1);
                break;
            }
        }
    }
}
