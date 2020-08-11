package _1011_Peaks_And_Valleys;

/**
 * Peaks and Valleys: In an array of integers, a "peak" is an element which is greater than or equal
 * to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent
 * integers. For example, in the array (5, 8, 6, 2, 3, 4, 6}, (8,6} are peaks and {5, 2} are valleys. Given an
 * array of integers, sort the array into an alternating sequence of peaks and valleys.
 * EXAMPLE
 * Input: (5,3,1,2,3}
 * Output: {5,1,3, 2,3}
 */
public class PeaksAndValleys {

    public static void sortArray(int[] array) {

        for (int i = 1; i < array.length; i += 2) {
            if (array[i - 1] < array[i]) {
                swapElements(array, i - 1, i);
            }
            if (i + 1 < array.length && array[i + 1] < array[i]) {
                swapElements(array, i + 1, i);
            }
        }
    }

    private static void swapElements(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
