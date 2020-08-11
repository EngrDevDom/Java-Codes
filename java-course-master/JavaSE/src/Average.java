import java.util.Scanner;

public class Average {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double sum = 0.;
        int count = 0;
        while(true) {
            int number = new Scanner(System.in).nextInt();

            if (number == -1)
                break;
            sum += number;
            count ++;
        }
        System.out.println(sum / count);
    }
}
