public class SavingsAccount
{
    private static double annualInterestRate = 0;
    private double savingsBalance;

    public SavingsAccount(double balance)
    {
        savingsBalance = balance;
    }

    public static void modifyInterestRate(double newValue)
    {
        if (newValue >= 0.0)
            annualInterestRate = newValue;
    }

    public double calculateMonthlyInterest()
    {
        final int NUM_MONTHS = 12;

        savingsBalance += (savingsBalance * annualInterestRate / NUM_MONTHS);
        return savingsBalance;
    }
}
