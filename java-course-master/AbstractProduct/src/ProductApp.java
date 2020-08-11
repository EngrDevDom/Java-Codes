import java.util.Scanner;

public class ProductApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Product Selector\n");
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter product code: ");
            String productCode = sc.next();
            sc.nextLine();

            Product p = ProductDB.getProduct(productCode);
            System.out.println();
            if (p != null)
//                System.out.println(p);
                System.out.println(p.getDisplayText());
            else
                System.out.println("No product matches this product code.");

            System.out.println("Product count: " + Product.getCount() + "\n");

            System.out.println("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
}
