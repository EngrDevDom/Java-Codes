package _803_Magic_Index;

/**
 * Magic Index: A magic index in an array A(l . .. n-1 ] is defined to bean index such that A[i ] =
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A,
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex {

    //we can use binary search given that the array is sorted and doesn't have duplicates
    public static int getMagicIndex(int[] sortedArray) {

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {

            int midIndex = (low + high) / 2;
            int midValue = sortedArray[midIndex];
            if (midIndex == midValue) {
                return midIndex;
            } else if (midValue > midIndex) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }
        return -1;
    }

    public static int getMagicIndexNonUnique(int[] sortedArray) {
       return getMagicIndexNonUnique(sortedArray, 0, sortedArray.length -1);
    }

    public static int getMagicIndexNonUnique(int[] sortedArray, int start, int end) {

        if (start > end || start < 0 || end >= sortedArray.length) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = sortedArray[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }

        //search the left part of the array
        int leftIndex = Math.min(midValue, midIndex - 1);
        int leftValue = getMagicIndexNonUnique(sortedArray, start, leftIndex);
        if (leftValue != -1) {
            return leftValue;
        }

        //search the right part
        int rightIndex = Math.max(midValue, midIndex + 1);
        return getMagicIndexNonUnique(sortedArray, rightIndex, end);
    }

}
