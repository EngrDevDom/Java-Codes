import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InverseWord {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());


        list.remove(2);

        for (int i = 0; i < list.size(); i++) {
            int j = list.size() - i - 1;
            System.out.println(list.get(j));
        }
    }
}
