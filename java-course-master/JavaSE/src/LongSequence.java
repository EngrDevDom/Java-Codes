import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LongSequence {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> n = new ArrayList<>(10);

        int count = 1, maxCount = 1;

        for (int i = 0; i < 10; i++)
            n.add(Integer.parseInt(reader.readLine()));


        for (int i = 0; i < 9; i++) {
            //if (n.get(i) == n.get(i + 1)) {
            if (n.get(i).equals(n.get(i + 1))) {
                count++;
                if (maxCount < count)
                    maxCount = count;
            }
            else
                count = 1;
        }
        System.out.println(maxCount);
    }
}
