import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class LineItem {
    private Product product;
    private int quantity;
    private  double total;

    public LineItem() {
        this.product = new Product();
        this.quantity = 0;
        this.total = 0;
    }

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        this.calculateTotal();
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public void calculateTotal() {
        total = quantity * product.getPrice();
    }

    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
    public String getFormattedQuantity() {
        NumberFormat number = NumberFormat.getNumberInstance();
        return number.format(quantity);

    }
}
