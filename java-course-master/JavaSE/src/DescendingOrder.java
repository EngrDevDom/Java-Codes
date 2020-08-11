import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DescendingOrder {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код

        int min = 0;

        for (int i = 0; i < 20; i ++) {
            for (int k = i+1; k < 20; k ++) {
                if (array[i] < array[k]) {
                    min = array[i];
                    array[i] = array[k];
                    array[k] = min;
                }
            }
        }

    }
}
