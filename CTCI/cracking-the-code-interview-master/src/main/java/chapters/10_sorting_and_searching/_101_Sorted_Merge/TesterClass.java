package _101_Sorted_Merge;

import java.util.Arrays;

public class TesterClass {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] b = {4,6,8};
        System.out.println("Original arrays: " + Arrays.toString(a) + " " + Arrays.toString(b));
        SortedMerge.sortedMerge(a,b, 4,2);
        System.out.println("Merged array: " + Arrays.toString(a));

    }
}
