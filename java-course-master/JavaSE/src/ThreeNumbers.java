import java.util.Scanner;

public class ThreeNumbers {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        int c = new Scanner(System.in).nextInt();
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();

        if (a == b)
            System.out.println(3);
        else   if (a == c)
            System.out.println(2);
        else   if (b == c)
            System.out.println(1);
        else   {
            ;
        }
    }
}
