import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int n, m;
        n = Integer.parseInt(reader.readLine());;
        m = Integer.parseInt(reader.readLine());;

        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < n; i++)
            strings.add(reader.readLine());

        for (int i = 0; i < m; i ++) {
            int j = 0;
            strings.add(n, strings.get(j));
            strings.remove(j);
        }

        for (int i = 0; i < strings.size(); i ++)
            System.out.println(strings.get(i));
    }
}
