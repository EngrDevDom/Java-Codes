package _804_Power_Set;

import java.util.ArrayList;
import java.util.List;

/**
 * Power Set: Write a method to return all subsets of a set.
 */
public class PowerSet {

    public static List<List<Integer>> getSubsets(int[] array) {

        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        generateSubsets(array, 0, subsets, set);

        return subsets;
    }

    private static void generateSubsets(int[] array, int i, List<List<Integer>> subsets, List<Integer> set) {

        if (i == array.length) {
            subsets.add(new ArrayList<>(set));
            return;
        }

        generateSubsets(array, i + 1, subsets, set);

        set.add(array[i]);
        generateSubsets(array, i + 1, subsets, set);
        set.remove(set.size() - 1);
    }
}
