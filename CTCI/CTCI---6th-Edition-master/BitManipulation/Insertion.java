
/**
 * Insertion for example taking n == 8 bit number
 * m  = 101
 */
public class Insertion {
    static int insert(int n, int m, int i, int j){
        // 11111111
        int all_ones = ~0;

        //left part ones behind j eg. 11100000 j = 4
        int left_ones = all_ones << (j+1);

        /*right part ones after ith position e.g.00000011 i = 2
            1 << i(2) = 00000100 + 2's complement of 1 =  11111111
            right_ones = 00000011
        */
        int right_ones = (1<<i)-1;

        //mask = 11100011
        int mask = left_ones | right_ones;

        //now clearing bits j through i and keeping all the values of 1's
        //0's in place in N integer
        int n_cleared = n & mask;
        //assuming m becomes 00010100
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        /*  Input : n = 10000000000(1024), m = 10011(19), i = 2, j = 6
            Output: 10001001100 => 1100
        */
        int n = insert(1024, 19, 2, 6);
        System.out.println(n);
    }
}