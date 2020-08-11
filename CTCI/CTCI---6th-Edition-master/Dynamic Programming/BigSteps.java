import java.util.Arrays;

/**
 * BigSteps
 */
public class BigSteps {
    public static long count_ways (int n) {
        long [] memo = new long[n+1];
        Arrays.fill(memo, -1);
        return count_ways(n, memo);
    }

    public static long count_ways(int n, long[] memo) {
        if(n<0) return 0;
        else if(n == 0) return 1;
        else if(memo[n] > -1){
            return memo[n];
        }else{
            memo[n] = count_ways(n-1,memo) + count_ways(n-2, memo) + count_ways(n-3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        long n = count_ways(40);
        System.out.println(n);
    }
}