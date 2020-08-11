package _108_Find_Duplicates;

import java.util.BitSet;

/**
 * Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000. The
 * array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
 * available, how would you print all duplicate elements in the array?
 */
public class FindDuplicates {

    public static void findDuplicates(int[] array) {

        //a 4KB vector is enough to hold 32000 bits
        BitSet bitSet = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (bitSet.get(number)) {
                System.out.println("Found duplicate: " + number + " ");
            } else {
                bitSet.set(number);
            }
        }
    }
}
