import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp {
    private static GenericQueue<Invoice> invoices = new GenericQueue<Invoice>();
    private static Invoice invoice;
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Welcome to the invoice application.\n");
        getInvoices();
        displayInvoices();
    }

    public static void getInvoices() {
        sc = new Scanner(System.in);
        int invoiceNumber = 1;
        String anotherInvoice = "y";
        while (anotherInvoice.equalsIgnoreCase("y")) {
            invoice = new Invoice();
            System.out.println("\nEnter line items for invoice " + invoiceNumber);
            getLineItems();
            invoices.push(invoice);

            anotherInvoice = Validator.getString(sc, "Another invoice? (y/n): ");
            System.out.println();
            invoiceNumber ++;
        }
    }

    public static void getLineItems() {
        String anotherItem = "y";
        while (anotherItem.equalsIgnoreCase("y")) {
            String productCode = Validator.getString(sc, "Enter product code: ");
            int quantity = Validator.getInt(sc, "Enter quantity: ", 0, 1000);
            Product product = ProductDB.getProduct(productCode);
            invoice.addItem(new LineItem(product, quantity));
            anotherItem = Validator.getString(sc, "Another line item? (y/n): ");
            System.out.println();
        }
    }
    public static void displayInvoices() {
        System.out.println("You entered the following invoices:\n");
        System.out.println("Number\tTotal");
        System.out.println("------\t-----");
        double batchTotal = 0;
        int invoiceNumber = 1;
        while (invoices.size() > 0) {
            Invoice invoice = invoices.pull();
            System.out.println(invoiceNumber + "\t" + invoice.getFormattedTotal());
            invoiceNumber ++;
            batchTotal += invoice.getInvoiceTotal();
        }
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Total for all invoices: " + currency.format(batchTotal));
    }
}
