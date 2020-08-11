package _807_Permutations_Without_Duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsWithoutDuplicates {

    public static List<List<Integer>> getPermutationsFromArray(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList();
        }
        List<List<Integer>> permutations = new ArrayList();
        permutations(array, 0, new boolean[array.length], permutations, new ArrayList());
        return permutations;
    }

    private static void permutations(int[] array, int index, boolean[] used, List<List<Integer>> permutations, List<Integer> list) {
        if (index == array.length) {
            permutations.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] == false) {
                list.add(array[i]);
                used[i] = true;
                permutations(array, index + 1, used, permutations, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static ArrayList<String> getPermutationsFromString(String source){

        ArrayList<String> results = new ArrayList<>();
        permutationsFromString("",source, results);
        return results;

    }

    private static void permutationsFromString(String prefix, String remainder, ArrayList<String> results){

        if(remainder.length() == 0){
            results.add(prefix);
        }
        int length = remainder.length();
        for(int i = 0; i < length; i++){
            String before = remainder.substring(0, i);
            String after = remainder.substring(i+1, length);
            char c = remainder.charAt(i);
            permutationsFromString(prefix + c, before + after, results);
        }






    }
}
