package RecurseMultiply;

/**
 * RecurseMultiply naive approach
 */
public class RecurseMultiply {

    public static long recurseMultiply(long a, long b) {

        if(a%2 != 0 && a != 1){
            long n = (long)Math.floor(a/2);
            long c = recurseMultiply(n, b);
            long tmp = a - (long)Math.floor(a/2);
            long d = recurseMultiply(tmp, b);
            long result = c + d;
            return result;
        }
        
        if(a == 1){
            for(int i = 0; i< b-1; i++){
                a += 1;
            }
            return a;
        }      
        long c = recurseMultiply(a/2, b);
        long d = recurseMultiply(a/2, b);
        long result = c + d;
        return result;
        }

    public static void main(String[] args) {
        long n = recurseMultiply(299977,293333);//87993153341
        System.out.println(n);
    }
}