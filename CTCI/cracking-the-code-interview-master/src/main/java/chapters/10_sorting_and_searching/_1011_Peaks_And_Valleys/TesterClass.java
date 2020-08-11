package _1011_Peaks_And_Valleys;

import java.util.Arrays;

public class TesterClass {

    public static void main(String[] args) {
        int[] array = {53, 12, 165, 12, 19, 10, 900, 123, 67, 99};
        PeaksAndValleys.sortArray(array);
        System.out.println("Sorted Array:  " + Arrays.toString(array));
    }
}
