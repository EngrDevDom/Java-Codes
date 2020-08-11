import java.text.NumberFormat;

public class Invoice {
        private double subtotal = 0.0;
        private String customerType = "";
        private double discountPercent;
        private double discountAmount;
        private double invoiceTotal;

        public Invoice(double subtotal, String customerType) {
            this.subtotal = subtotal;
            this.customerType = customerType;
        }

        public double getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(double discountAmount) {
            this.discountAmount = discountAmount;
        }

        public double getInvoiceTotal() {
            return invoiceTotal;
        }

        public void setInvoiceTotal(double invoiceTotal) {
            this.invoiceTotal = invoiceTotal;
        }

        public double getDiscountPercent() {
            return discountPercent;
        }

        public void setDiscountPercent(double discountPercent) {
            this.discountPercent = discountPercent;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
            this.subtotal = subtotal;
        }

        public String getCustomerType() {
            return customerType;
        }

        public void setCustomerType(String customerType) {
            this.customerType = customerType;
        }

        public static void getInvoice(double discountPercent, double discountAmount, double invoiceTotal) {
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();

            String message = "Discount percent: " + percent.format(discountPercent) + "\n"
                    + "Discount amount: " + currency.format(discountAmount) + "\n"
                    + "Invoice total: " + currency.format(invoiceTotal) + "\n";
            System.out.println(message);
        }


}
