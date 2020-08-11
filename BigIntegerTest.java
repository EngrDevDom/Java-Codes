import java.math.*;
import java.util.*;

/**
 * This program uses big numbers to compute the odds of winning the lottery.
 */

 public class BigIntegerTest {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? >> ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? >> ");
        int n = in.nextInt();

        /**
         * Compute Binomial Coefficient
         * n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */

        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - BigInteger.valueOf(i)));

        System.out.println("Your odds are 1 in " + lotteryOdds + ".");

    }
}
