package _801_Triple_Step;

import java.util.Arrays;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStep {

    //simple solution, but it's bad O(n^3)
    public static int countNumberOfWays(int n) {

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countNumberOfWays(n - 1) + countNumberOfWays(n - 2) + countNumberOfWays(n - 3);
        }

    }

    //use memoization
    public static int countNumberOfWaysMemo(int n) {
        //array is better than Map for this case
        int[] steps = new int[n + 1];
        Arrays.fill(steps, -1);
        return countWays(n, steps);
    }

    private static int countWays(int n, int[] steps) {

        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        }
        if (steps[n] > 0) {
            return steps[n];
        }

        steps[n] = countWays(n - 1, steps) + countWays(n - 2, steps) + countWays(n - 3, steps);
        return steps[n];
    }

}
