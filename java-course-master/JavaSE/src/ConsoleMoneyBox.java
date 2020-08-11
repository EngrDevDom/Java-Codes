import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleMoneyBox {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum = 0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String s = buffer.readLine();

            if (s.equals("сумма"))
                break;
            int a = Integer.parseInt(s);
            sum += a;
        }
        System.out.println(sum);
    }
}
