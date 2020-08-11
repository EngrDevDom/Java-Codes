import java.util.Locale;
import java.util.Scanner;

public class InvoiceApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        String choise = "y";
        while(choise.equalsIgnoreCase("y")) {
            System.out.print("Enter subtotal: ");
            double subtotal = sc.nextDouble();

            double discountPercent = 0.0;
            if(subtotal >= 200)
                discountPercent = .2;
            else  if (subtotal >= 100)
                discountPercent = .1;
            else
                discountPercent = .0;

            double discountAmount = subtotal * discountPercent;
            double invoiceTotal = subtotal - discountAmount;

            String message = "Discount percent: " + discountPercent + "\n"
                    + "Discount amount: " + discountAmount + "\n"
                    + "Invoice total: " + invoiceTotal + "\n";

            System.out.println(message);

            System.out.println("Continue? (y/n): ");
            choise = sc.next();
            System.out.println();
        }
    }
}
