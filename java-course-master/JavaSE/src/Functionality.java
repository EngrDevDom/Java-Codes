import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Functionality {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        while (true) {
            String string = reader.readLine();
            if (string == null || string.isEmpty()) break;
            strings.add(string);
        }
        ArrayList<String> resultStrings = new ArrayList<String>();

        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            resultStrings.add(s.length() % 2 == 0 ? (s + " " + s) : (s + " " + s + " " + s));

            System.out.print(resultStrings.get(i));
            System.out.println();
        }
    }
}
