public class swapBits {
    //implemented using 32 bit integers, if working with 64 bit ints change the mask
    public static int swapBits(int a) {
        /*0x55555555 == 1431655765
          0xaaaaaaaa == -1431655766 */
        System.out.println();
        return ((a & 0xaaaaaaaa) >>> 1) | ((a & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        //1010 becomes 0101
        int n = swapBits(10);
        System.out.println(n);

    }
}