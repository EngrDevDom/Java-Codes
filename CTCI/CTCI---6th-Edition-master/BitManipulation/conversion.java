

public class conversion {

    public static int different_bits(int a, int b) {
        // a = 11101 b = 01111
        int count = 0;
        while(a != 0 || b != 0){
            /*a = a&1;
            b = b&1;
            c = a^b;*/
            if(((a&1)^(b&1)) == 1){
                count++;
            }
            a >>>= 1;
            b >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = different_bits(29,15);
        int m = different_bits(21, 10);
        System.out.println("Different in 29,15 "+n);
        System.out.println("Different in 21,10 "+m);
    }
}