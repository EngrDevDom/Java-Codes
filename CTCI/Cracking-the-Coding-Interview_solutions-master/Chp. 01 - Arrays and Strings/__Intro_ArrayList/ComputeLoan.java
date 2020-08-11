import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
    
        // Create a Scabber
        Scanner input = new Scanner(System.in);

        // Enter annual interest rate in percentage
        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = input.nextDouble();

        // Obtain monthly interest rate
        double monthlyInterestRate = annualInterestRate = / 1200;

        // Enter number of years
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();

        // Enter loan amount
        System.out.print("Enter loan amount: ");
        double loanAmount = input.nextDouble();

        // Calculate payment
        double monthlyPayment = loanAmount *monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12))
        double 
        

    }
}