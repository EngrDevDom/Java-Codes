import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinimumOfNNumbers {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
        int minimum = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < minimum)
                minimum = array.get(i);
        }
        return minimum;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(reader.readLine()));

        return list;
    }
}
