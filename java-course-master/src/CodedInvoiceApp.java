import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CodedInvoiceApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        String choise = "y";
        while(choise.equalsIgnoreCase("y")) {
            System.out.println("Enter customer type: (r/c): ");
            String customerType = sc.next();

            System.out.print("Enter subtotal: ");
            double subtotal = sc.nextDouble();

            double discountPercent = 0.0;
            if(customerType.equalsIgnoreCase("R")) {
                if (subtotal < 100)
                    discountPercent = 0;
                else if (subtotal >= 100 && subtotal < 250)
                    discountPercent = .1;
                else if (subtotal >= 250)
                    discountPercent = .2;
            }
            else if(customerType.equalsIgnoreCase("C")) {
                if(subtotal < 250)
                    discountPercent = .2;
                else
                    discountPercent = .3;
            }
            else
                discountPercent = .1;

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
}
