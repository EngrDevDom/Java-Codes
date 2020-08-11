import java.util.Scanner;

public class Summation {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int sum = 0, number;
        while(true) {
//            int number = new Scanner(System.in).nextInt();
//            int number = sc.nextInt();
            number = sc.nextInt();
            if (number == -1)
                break;
            sum += number;
        }
        System.out.println(sum);
    }
}
