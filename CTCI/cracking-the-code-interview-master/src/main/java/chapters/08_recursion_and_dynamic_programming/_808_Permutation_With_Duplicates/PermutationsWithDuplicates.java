package _808_Permutation_With_Duplicates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PermutationsWithDuplicates {


    public static ArrayList<String> permutationsFromString(String source) {
        ArrayList<String> results = new ArrayList<>();
        Map<Character, Integer> charsMap = buildCharsMap(source);
        buildPermutations(charsMap, "", source.length(), results);
        return results;
    }

    private static Map<Character, Integer> buildCharsMap(String source) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for (char c : source.toCharArray()) {
            if (!charsMap.containsKey(c)) {
                charsMap.put(c, 0);
            }
            charsMap.merge(c, 1, Integer::sum);
        }
        return charsMap;
    }

    private static void buildPermutations(Map<Character, Integer> charsMap, String prefix, int remaining, ArrayList<String> result) {

        //Base case
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        for (Character c : charsMap.keySet()) {
            int count = charsMap.get(c);
            if (count > 0) {
                charsMap.put(c, count - 1);
                buildPermutations(charsMap, prefix + c, remaining - 1, result);
                charsMap.put(c, count);
            }
        }
    }

}
