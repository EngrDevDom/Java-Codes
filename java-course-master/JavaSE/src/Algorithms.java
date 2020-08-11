import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algorithms {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        //напишите тут ваш код
        //int maximum = 0;
        int n = Integer.parseInt(reader.readLine());
        while(n < 1) {
            System.out.println("Enter the number larger than 0!");
            n = Integer.parseInt(reader.readLine());
            //    break;
        }




        //int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i ++) {
            numbers[i]  = Integer.parseInt(reader.readLine());
        }
        int maximum = numbers[0];
        for (int i = 0; i < numbers.length; i ++) {

            //   maximum = numbers[i] > numbers[0] ? numbers[i] : numbers[0];
            maximum = numbers[i] > maximum ? numbers[i] : maximum;
        }

        System.out.println(maximum);
    }
}
