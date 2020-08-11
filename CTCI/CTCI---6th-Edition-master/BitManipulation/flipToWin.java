


public class flipToWin {

    public static int flipBit(int num) {

        if(num == ~0)   return Integer.BYTES*8;

        // num = 11011101111
        // flipping 2nd 0 from left gives 8 1's
        int current_length = 0;
        int previous_length = 0;
        int max_length = 1;     
        //sequence will always be atleast 1 {21(zeroes),2(ones),1(zeroes),...,4(ones),0(zeroes)}

        while(num != 0){
            if((num & 1) == 1){
                current_length++;
            }else if((num&1) == 0){
                //if next bit from the right is again zero then 0 else currentlength e.g 4
                previous_length = (num&2) == 0?0:current_length;
                current_length = 0;
            }
            max_length = Math.max(current_length+previous_length+1, max_length);
            num >>>= 1;
        }
        return max_length;        
    }

    public static void main(String[] args) {
        int n = flipBit(1775);
        System.out.println(n);
    }
}