import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class EnhancedInvoiceApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();


        String choise = "y";
        while(choise.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            sc.useLocale(Locale.ENGLISH);

            System.out.println("Enter customer type: (r/c/t): ");
            String customerType = sc.next();

            System.out.print("Enter subtotal: ");
            double subtotal = sc.nextDouble();

            double discountPercent = getDiscountPercent(customerType, subtotal);
            double discountAmount = subtotal * discountPercent;
            double invoiceTotal = subtotal - discountAmount;

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();


            String message = "Discount percent: " + percent.format(discountPercent) + "\n"
                           + "Discount amount: " + currency.format(discountAmount) + "\n"
                           + "Invoice total: " + currency.format(invoiceTotal) + "\n";

            System.out.println(message);

            System.out.println("Continue? (y/n): ");
            choise = sc.next();
            System.out.println();
        }
    }
    public static double getDiscountPercent(String s, double st) {

        double discountPercent = 0.0;

        if(s.equalsIgnoreCase("R")) {
//                System.out.println("R or r was chosen");
            if (st >= 250 && st < 500)
                discountPercent = .25;
            else if (st >= 500)
                discountPercent = .3;
        }
        else if(s.equalsIgnoreCase("C")) {
//                System.out.println("C or c was chosen");
            discountPercent = .2;
        }
        else if(s.equalsIgnoreCase("T")) {
//                System.out.println("T or t was chosen");
            if(st < 500)
                discountPercent = .4;
            else if(st >= 500)
                discountPercent = .5;
        }
        else
            discountPercent = .1;

        return discountPercent;
    }
}
