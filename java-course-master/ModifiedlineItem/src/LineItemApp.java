//import javax.xml.validation.Validator;
import java.util.Scanner;

public class LineItemApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Line Item Calculator\n");
        Scanner sc = new Scanner(System.in);
        String choise = "y";
        while (choise.equalsIgnoreCase("y")) {
            String productCode = Validator.getString(sc, "Enter product code: ");
            int quantity = Validator.getInt(sc, "Enter quantity: ", 0, 1000);
            Product product = ProductDB.getProduct(productCode);
            LineItem lineItem = new LineItem(product, quantity);

            lineItem.getObjectCount();
            System.out.println("\nLINE ITEM");
            System.out.println("Code:              " + product.getCode());
            System.out.println("Description:       " + product.getDescription());
            System.out.println("Price:             " + product.getFormattedPrice());
            System.out.println("Quantity:          " + lineItem.getQuantity());
            System.out.println("Total:             " + lineItem.getFormattedTotal());
            System.out.println("Number of objects: " + lineItem.getObjectCount() + "\n");

            choise = Validator.getString(sc, "Continue? (y/n): ");
            System.out.println();
        }
    }
}
