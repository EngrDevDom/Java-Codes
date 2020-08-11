import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ExceptionFunctionInvoiceApp {
    public static final String ENTER_SUBTOTAL = "Enter subtotal: ";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        String choice = "y";
        double subtotal = 0.;
        while (choice.equalsIgnoreCase("y")) {
            System.out.println(ENTER_SUBTOTAL);
            subtotal = getValidSubtotal(sc);

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
    public static double getValidSubtotal(Scanner sc) {
        double st = 0.;
        boolean isValid = false;
        while (isValid == false) {
            if (sc.hasNextDouble()) {
                st = sc.nextDouble();

                if (st < 0. || st > 10000) {
                    System.out.println("Error! Number must be greater than 0 and less than or equal to 10000");
                    System.out.println(ENTER_SUBTOTAL);
                    sc.nextLine();
                    continue;
                }
                isValid = true;
            }
        }
        return st;
    }
}
