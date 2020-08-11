import java.util.Locale;
import java.util.Scanner;

public class InvoiceApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();


        String choise = "y";
        while (choise.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            sc.useLocale(Locale.ENGLISH);

            System.out.println("Enter customer type: (r/c/t): ");
            String customerType = sc.next();

            System.out.print("Enter subtotal: ");
            double subtotal = sc.nextDouble();

            Invoice invoice = new Invoice(subtotal, customerType);


            if (invoice.getCustomerType().equalsIgnoreCase("R")) {
                if (invoice.getSubtotal() >= 250 && invoice.getSubtotal() < 500)
                    invoice.setDiscountPercent(.25);
                else if (invoice.getSubtotal() >= 500)
                    invoice.setDiscountPercent(.3);
            } else if (invoice.getCustomerType().equalsIgnoreCase("C")) {
                invoice.setDiscountPercent(.2);
            } else if (invoice.getCustomerType().equalsIgnoreCase("T")) {
                if (invoice.getSubtotal() < 500)
                    invoice.setDiscountPercent(.4);
                else if (invoice.getSubtotal() >= 500)
                    invoice.setDiscountPercent(.5);
            } else
                invoice.setDiscountPercent(.1);

            invoice.setDiscountAmount(invoice.getSubtotal() * invoice.getDiscountPercent());
            invoice.setInvoiceTotal(invoice.getSubtotal() - invoice.getDiscountAmount());
            invoice.getInvoice(invoice.getDiscountPercent(), invoice.getDiscountAmount(), invoice.getInvoiceTotal());

            System.out.println("Continue? (y/n): ");
            choise = sc.next();
            System.out.println();
        }
    }
}
