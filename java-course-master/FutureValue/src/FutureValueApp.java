import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Future Value Calculator\n");
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("DATA ENTRY");
            double monthlyInvestment = Validator.getDouble(sc, "Enter monthly investment: ", 0, 1000);
            double interestRate = Validator.getDouble(sc, "Enter yearly interest rate: ", 0, 30);
            int years = Validator.getInt(sc, "Enter number of years: ", 0, 100);

            double monthlyInterestRate = interestRate/12/100;
            int months = years * 12;
            double futureValue = FinancialCalculations.calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMaximumFractionDigits(1);

            String results = "Monthly investment:\t"
                    + currency.format(monthlyInvestment) + "\n"
                    + "Yearly interest rate:\t"
                    + percent.format(interestRate/100) + "\n"
                    + "Number of years:\t"
                    + years + "\n"
                    + "Future Value:\t\t"
                    + currency.format(futureValue) + "\n";

            System.out.println();
            System.out.println("FORMATTED RESULTS");
            System.out.println(results);

            System.out.println("continue? (y/n): ");
            choice = sc.next();
            sc.nextLine();
            System.out.println();
        }
    }

}
