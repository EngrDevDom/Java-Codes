import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreetAndBuildings {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[15];
        int even, odd;
        even = odd = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            String s = reader.readLine();
            numbers[i] = Integer.parseInt(s);
            if (i % 2 == 0)
                even += numbers[i];
            else
                odd += numbers[i];
        }

        if (even > odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");


    }
}
