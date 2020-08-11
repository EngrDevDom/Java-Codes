import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private ArrayList<LineItem> lineItems;
    private LocalDateTime invoiceDate;

    public Invoice() {
        lineItems = new ArrayList<LineItem>();
        invoiceDate = LocalDateTime.now();
    }
    public void addItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }
    public double getInvoiceTotal() {
        double invoiceTotal = 0;
        for (LineItem lineItem : this.lineItems)
            invoiceTotal += lineItem.getTotal();
        return invoiceTotal;
    }
    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getInvoiceTotal());
    }
    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }
    public String getFormattedDate() {
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        return shortDate.format(invoiceDate);
    }
    public LocalDateTime getDueDate() {
        LocalDateTime dueDate = invoiceDate.plusDays(30);
        return dueDate;
    }
    public String getFormattedDueDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return dtf.format(getDueDate());
    }
    public String getFormattedInvoiceDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return dtf.format(invoiceDate);
    }
}
