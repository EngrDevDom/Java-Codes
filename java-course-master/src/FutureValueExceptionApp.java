import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FutureValueExceptionApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Future Value Calculator\n");
        Scanner sc = new Scanner(System.in);

        String choice = "y";
        while (!choice.equalsIgnoreCase("n")) {
            double monthlyInvestment = 0.;
            double interestRate = 0.;
            int years = 0;
            try {
                System.out.print("Enter monthly investment: ");
                monthlyInvestment = sc.nextDouble();

                System.out.print("Enter yearly interest rate: ");
                interestRate = sc.nextDouble();

                System.out.println("Enter number of years: ");
                years = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Error! Invalid number. Try again.\n");
                continue;
            }

            double monthlyInterestRate = interestRate/12/100;
            int months = years * 12;
            double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("Future value: " + currency.format(futureValue));
            System.out.println();
            System.out.println("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }

    private static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) {
        double futureValue = 0.0;
        for(int i = 1; i <= months; i ++)
            futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);

        return futureValue;


    }
}
