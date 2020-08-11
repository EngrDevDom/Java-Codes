import java.text.NumberFormat;
import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> lineItems;
    public Invoice() {
        lineItems = new ArrayList<LineItem>();
    }
    public void addItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }
    public double getInvoiceTotal() {
        double invoiceTotal = 0;
        for (LineItem lineItem : this.lineItems) {
            invoiceTotal += lineItem.getTotal();
        }
        return invoiceTotal;
    }
    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getInvoiceTotal());
    }
}
