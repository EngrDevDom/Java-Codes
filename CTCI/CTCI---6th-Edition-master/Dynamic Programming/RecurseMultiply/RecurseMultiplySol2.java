package RecurseMultiply;

//Memoization approach
public class RecurseMultiplySol2 {
    public static long recurseMultiply(int a , int b) {
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;
        long[] memo = new long[smaller +1];
        return recurseMultiply(smaller, bigger, memo);
    }

    public static long recurseMultiply(int smaller,int bigger, long[] memo) {
        if(smaller == 0) return 0;
        else if (smaller == 1) return bigger;
        else if (memo[smaller] > 0) return memo[smaller];

        int s = smaller >> 1;
        long side1 = recurseMultiply(s, bigger, memo);
        long side2 = side1;

        if(smaller % 2==1){
            side2 = recurseMultiply(smaller - s, bigger, memo);
        }

        //sum and cache
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }

    public static void main(String[] args) {
        long n = recurseMultiply(2999777,2933333);//8799344866741
        System.out.println(n);
    }
}