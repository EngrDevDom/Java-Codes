import java.text.NumberFormat;

public class Product {
    private String code;
    private String description;
    private double price;

//    private static int objectCount = 0;

    public Product() {
        code = "";
        description = "";
        price = 0.;
//        objectCount ++;
    }

    public Product(String code) {
        this.code = code;
        Product p = ProductDB.getProduct(code);
        description = p.getDescription();
        price = p.getPrice();
    }

//    public Product(String code, String description, double price) {
//        this.code = code;
//        this.description = description;
//        this.price = price;
//    }
//
//    public Product(String c, String d, double p) {
//        code = c;
//        description = d;
//        price = p;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public static void setObjectCount(int objectCount) {
//        Product.objectCount = objectCount;
//    }

//    public static int getObjectCount() {
//        return objectCount;
//    }

    public String getFormattedPrice() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}
//    private String code;
//    private String description;
//    private double price;
//
//    /**
//     * Creates a <code>Product</code> with default values.
//     */
//    public Product() {
//        code = "";
//        description = "";
//        price = 0;
//    }

    /**
     * Sets the product's code.
     * @param code a <code>String</code> for the product's code
     */
//    public void setCode(String code) {
//        this.code = code;
//    }

    /**
     * Gets the product's code.
     * @return a <code>String</code> for the product's code
     */
//    public String getCode() {
//        return code;
//    }

    /**
     * Sets the product's description.
     * @param description a <code>String</code> for the product's description
     */
//    public void setDescription(String description) {
//        this.description = description;
//    }

    /**
     * Gets the product's description.
     * @return a <code>String</code> for the product's description
     */
//    public String getDescription() {
//        return description;
//    }

    /**
     * Sets the product's price.
     * @param price a <code>double</code> value for the product's price
     */
//    public void setPrice(double price) {
//        this.price = price;
//    }

    /**
     * Gets a <code>double</code> value for the product's price.
     * @return a <code>double</code> value that represents the product's price
     */
//    public double getPrice() {
//        return price;
//    }

    /**
     * Gets a <code>String</code> for the product's price with
     * standard currency formatting
     * @return a <code>String</code> for the product's price with
     *         standard currency formatting applied ($1,000.00).
     */
//    public String getPriceFormatted() {
//        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        return currency.format(price);
//    }