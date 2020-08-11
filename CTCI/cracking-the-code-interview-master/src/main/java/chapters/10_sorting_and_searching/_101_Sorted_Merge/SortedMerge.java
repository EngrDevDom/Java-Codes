package _101_Sorted_Merge;

/**
 * Sorted Merge: You are given two sorted arrays, A and 8, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order,
 */
public class SortedMerge {

    public static void sortedMerge(int[] a, int[] b, int lastIndexA, int lastIndexB) {

        int current = lastIndexA + lastIndexB + 1;
        while (lastIndexA >= 0 && lastIndexB >= 0) {
            if (a[lastIndexA] > b[lastIndexB]) {
                a[current--] = a[lastIndexA--];
            } else {
                a[current--] = b[lastIndexB--];
            }
        }

        while (lastIndexB >= 0) {
            a[current--] = b[lastIndexB];
        }
    }
}
