import java.util.Scanner;

public class SomehowMediocre {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a, b, c;
        a = new Scanner(System.in).nextInt();
        b = new Scanner(System.in).nextInt();
        c = new Scanner(System.in).nextInt();

        if (a >= b && a <= c)
            System.out.println(a);
        else   if (b >= a && b <= c)
            System.out.println(b);
        else   if (b <= a && b >= c)
            System.out.println(b);
        else   if (a <= b && a >= c)
            System.out.println(a);
        else   if (c <= a && c >= b)
            System.out.println(c);
        else   if (c >= a && c <= b)
            System.out.println(c);
    }
}
