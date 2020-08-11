package _807_Permutations_Without_Duplicates;

import java.util.Arrays;
import java.util.List;

public class TesterClass {

    public static void main(String[] args) {
        int[] array = {0, 1};
        List<List<Integer>> permutations = PermutationsWithoutDuplicates.getPermutationsFromArray(array);
        System.out.println("Source array: " + Arrays.toString(array));
        System.out.println("Permutations from array: " + permutations + "\n");

        String test = "ab";
        System.out.println("Source string: " + test);
        System.out.println("Permutations from string = " + PermutationsWithoutDuplicates.getPermutationsFromString(test));



    }
}
