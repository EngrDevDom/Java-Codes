import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ExceptionFormattedInvoiceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        String choice = "y";
        double subtotal = 0.;
        while (choice.equalsIgnoreCase("y")) {
            try {
                System.out.println("Enter subtotal: " );
                subtotal = sc.nextDouble();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Error! Invalid number. Try again.\n");
                continue;
            }

            double discountPercent = 0.;
            if (subtotal >= 100)
                discountPercent = .1;
            else
                discountPercent = .0;

            double discountAmount = subtotal * discountPercent;
            double totalBeforeTax = subtotal - discountAmount;
            double salesTax = totalBeforeTax * .05;
            double total = totalBeforeTax + salesTax;

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();

            String debugMessage = "\nUNFORMATTED RESULTS\n"
                    + "Discount percent: " + discountPercent + "\n"
                    + "Discount amount:  " + discountAmount + "\n"
                    + "Total before tax: " + totalBeforeTax + "\n"
                    + "Sales tax:        " + salesTax + "\n"
                    + "Invoice total:    " + total + "\n";
            System.out.println(debugMessage);

            String message = "Discount percent: " + percent.format(discountPercent) + "\n"
                    + "Discount amount:  " + currency.format(discountAmount) + "\n"
                    + "Total before tax: " + currency.format(totalBeforeTax) + "\n"
                    + "Sales tax:        " + currency.format(salesTax) + "\n"
                    + "Invoice total:    " + currency.format(total) + "\n";

            System.out.println(message);

            System.out.println("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
}
