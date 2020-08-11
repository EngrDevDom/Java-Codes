import java.text.NumberFormat;

public class LineItem {
    private Product product;
    private int quantity;
    private double total;

    private static int objectCount = 0;

    public LineItem() {
        this.product = new Product();
//        product = null;
//        quantity = 0;
//        total = 0;
//        objectCount ++;
//        this.product = null;
        this.quantity = 0;
        this.total = 0;
        this.objectCount ++;
    }
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.setObjectCount(objectCount);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        total = quantity * product.getPrice();
        return total;
    }
    private void calculateTotal() {
        total = quantity * product.getPrice();
    }

    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

    public void setObjectCount(int objectCount) {
        LineItem.objectCount = objectCount;
    }

    public int getObjectCount() {
        return objectCount ++;
    }
}
