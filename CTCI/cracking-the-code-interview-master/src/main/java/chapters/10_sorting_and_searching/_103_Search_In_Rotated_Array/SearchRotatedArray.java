package _103_Search_In_Rotated_Array;


/**
 * Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
 * number of times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * EXAMPLE
 * Input:find 5 in(15 , 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 */
public class SearchRotatedArray {


    public static int searchRotatedArray(int[] array, int target) {
        //use a version of binary search
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int middle = (low + high) / 2;
            if (array[middle] == target) {
                return middle;
            }
            if (array[low] < array[middle]) {
                if (array[low] <= target && target < array[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else if (array[low] > array[middle]) {
                if (array[middle] < target && target <= array[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                low++;
            }
        }
        return -1;
    }


}
