import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReverseOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
            nums.add(Integer.parseInt(reader.readLine()));


        for (int i = 9; i >= 0; i--)
            System.out.println(nums.get(i));

    }
}
