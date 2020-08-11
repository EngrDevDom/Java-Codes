import java.util.Locale;
import java.util.Scanner;

public class InvoiceApp {
    public static Invoice invoice = new Invoice();

    public static void main(String[] args) {
        System.out.println("Welcome to the invoice application.\n");
        getLineItems();
        displayInvoice();
    }
    public static void getLineItems() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            String productCode = Validator.getString(sc, "Enter product code: ");
            int quantity = Validator.getInt(sc,"Enter quantity:   ", 0, 1000);
            Product product = ProductDB.getProduct(productCode);
            invoice.addItem(new LineItem(product, quantity));
            choice = Validator.getString(sc, "Another line item? (y/n)): ");
            System.out.println();
        }
    }
    public static void displayInvoice() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice date: ");
        sb.append(invoice.getFormattedInvoiceDate());
        sb.append("\n");
        sb.append("Due date:    ");
        sb.append(invoice.getFormattedDueDate());
        sb.append("\n\n");

        sb.append(StringUtil.pad("Description", 34));
        sb.append(StringUtil.pad("Price", 10));
        sb.append(StringUtil.pad("Qty", 5));
        sb.append(StringUtil.pad("Total", 10));
        sb.append("\n");

        for (LineItem lineItem : invoice.getLineItems()) {
            Product product = lineItem.getProduct();
            sb.append(StringUtil.pad(product.getDescription(), 34));
            sb.append(StringUtil.pad(product.getFormattedPrice(), 10));
            sb.append(StringUtil.pad(lineItem.getFormattedQuantity(), 5));
            sb.append(StringUtil.pad(lineItem.getFormattedTotal(), 10));
            sb.append("\n");
        }
        sb.append("\nInvoice total: ");
        sb.append(invoice.getFormattedTotal());
        sb.append("\n");
        System.out.println(sb);
    }
}
