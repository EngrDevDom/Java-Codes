import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueValidationApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Future Value Calculator\n");
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("DATA ENTRY");
            double monthlyInvestment = getDoubleWithRange(sc, "Enter monthly investment: ", 0, 1000);
            double interestRate = getDoubleWithRange(sc, "Enter yearly interest rate: ", 0, 30);
            int years = getIntWithRange(sc, "Enter number of years: ", 0, 100);

            double monthlyInterestRate = interestRate/12/100;
            int months = years * 12;
            double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

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

    public  static double getDouble(Scanner sc, String primpt) {
        double d = 0.0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.println(primpt);
            if(sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            }
            else
                System.out.println("Error! Invalid decimal value. Try again.");
            sc.nextLine();
        }
        return d;
    }

    public static double getDoubleWithRange(Scanner sc, String prompt, double min, double max) {
        double d = 0.0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d < min)
                System.out.println("Error! Number must be greater than " + min + ".");
            else if (d >= max)
                System.out.println("Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return d;
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.println(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            }
            else
                System.out.println("Error! Invalid integer value. Try again.");
            sc.nextLine();
        }
        return i;
    }

    public static int getIntWithRange(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i <= min)
                System.out.println("Error! Number must be greater than " + min + ".");
            else if (i >= max)
                System.out.println("Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return i;
    }


    public static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) {
        double futureValue = 0;
        for (int i = 1; i <= months; i ++)
            futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
        return  futureValue;
    }

}
