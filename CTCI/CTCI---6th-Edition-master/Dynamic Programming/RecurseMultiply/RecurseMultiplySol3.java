package RecurseMultiply;

public class RecurseMultiplySol3 {
    public static long recurseMultiply(long a, long b) {
        long bigger = a < b ? b : a;
        long smaller = a < b ? a : b; 
        return recurseMultiplyHelper(smaller, bigger);
    }

    public static long recurseMultiplyHelper(long smaller, long bigger) {
        if(smaller == 0) return 0;
        else if(smaller == 1) return bigger;

        long s = smaller >> 1; //divide by 2
        long halfprod = recurseMultiplyHelper(s, bigger);

        if(smaller % 2 == 0){
            return halfprod + halfprod;
        }
        return halfprod + halfprod + bigger;
    }
    public static void main(String[] args) {
        long n = recurseMultiply(2999777,2933333);//8799344866741 inputs are bigger
        System.out.println(n);
    }
}