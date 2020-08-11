import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (!choice.equalsIgnoreCase("n")) {
            System.out.print("Enter monthly investment: ");
            double monthlyInvestment = sc.nextDouble();

            System.out.print("Enter yearly interest rate: ");
            double interestRate = sc.nextDouble();

            System.out.println("Enter number of years: ");
            int years = sc.nextInt();

            double monthlyInterestRate = interestRate/12/100;
            int months = years * 12;
            double futureValue = 0.0;

            for(int i = 1; i <= months; i ++) {
                futureValue = (futureValue + monthlyInvestment) *
                              (1 + monthlyInterestRate);
                System.out.println(i + "\t" + futureValue);
            }
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("Future value: " + currency.format(futureValue));
            System.out.println();
            System.out.println("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
}
