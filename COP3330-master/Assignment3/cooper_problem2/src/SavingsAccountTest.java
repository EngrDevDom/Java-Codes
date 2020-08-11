public class SavingsAccountTest
{
    private static SavingsAccount saver1 = new SavingsAccount(2000);
    private static SavingsAccount saver2 = new SavingsAccount(3000);

    public static void main(String[] args)
    {
        int i;
        SavingsAccount.modifyInterestRate(0.04);

        System.out.println("|–––––––––––––––––––––––––––|");
        System.out.println("| Month | Saver 1 | Saver 2 |");
        System.out.println("|–––––––––––––––––––––––––––|");
        for (i = 1; i <= 12; i++)
        {
            System.out.printf("|   %2d  | %.2f | %.2f |", i, saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
            System.out.println();
            System.out.println("|–––––––––––––––––––––––––––|");
        }

        SavingsAccount.modifyInterestRate(0.05);
        System.out.printf("|   13  | %.2f | %.2f |", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
        System.out.println();
        System.out.println("|–––––––––––––––––––––––––––|");

    }
}
