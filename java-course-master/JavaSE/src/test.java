import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class test {
    public static void schijven() {
        System.out.println("Hello, I am static!");
    }

    public void nogSchrijven() {
        System.out.println("Hi, guys I am non static!");
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.useLocale(Locale.ENGLISH);
//
        Date now = new Date();
        String currentDate = now.toString();

//        test t = new test();
//
//
//        System.out.println("Enter product code: ");
//        String pcode = scanner.next();
//
//        System.out.println("Enter price: ");
//        double price = scanner.nextDouble();
//
//        System.out.println("Enter quantity: ");
//        int quan = scanner.nextInt();

//        System.out.println(pcode + " "+ price +" " + quan);
        System.out.println("The time now is: " + now);
        System.out.println("The current time is: " + currentDate);
        schijven();
//        t.nogSchrijven();
        String str = "abcdefgh";
        String cde = "cde";
        System.out.println("abcdefgh".substring(2,4));
        System.out.println(cde.substring(1,2));
    }

    
}
