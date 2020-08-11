import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SingleArraysConversation {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] list = new String[10];
        int[] numbers = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < list.length; i++) {
            list[i] = reader.readLine();


            //for (int i = 0; i < numbers.length; i++)
            numbers[i] = list[i].length();
        }
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);

    }
}
