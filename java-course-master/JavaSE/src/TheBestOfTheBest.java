import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TheBestOfTheBest {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();

        int minLengthIndex = 0;
        int maxLengthIndex = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            strings.add(reader.readLine());

        int max = strings.get(0).length();
        int min = strings.get(0).length();

        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() > max) {
                max = strings.get(i).length();
                maxLengthIndex = i;
            }
        }

        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() < min) {
                min = strings.get(i).length();
                minLengthIndex = i;
            }
        }

        if(minLengthIndex >= maxLengthIndex)
            System.out.println(strings.get(maxLengthIndex));
        else
            System.out.println(strings.get(minLengthIndex));
    }
}
