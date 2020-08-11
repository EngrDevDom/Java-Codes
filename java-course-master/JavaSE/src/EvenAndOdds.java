import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenAndOdds {
    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        //int number;
        //String len;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String snumber = reader.readLine();
        char[] result = snumber.toCharArray();


        for (int i = 0; i < result.length; i++) {
            if (result[i] % 2 == 0)
                even ++;
            else
                odd ++;

        }
        System.out.println("Even: " + even + " Odd: " + odd);

    }
}
