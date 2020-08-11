package _102_Check_Permutation;

import java.util.HashMap;

/**
 * Function that tests if two strings are permutations
 */
public class CheckStringPermutations {

    private static final int NUMBER_OF_ASCII_CHARS = 256;

    public static boolean isPermutation(String source, String test) {
        if (source.length() != test.length()) {
            return false;
        }
        HashMap<Character, Integer> charactersMap = new HashMap(NUMBER_OF_ASCII_CHARS);
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            charactersMap.merge(ch, 1, Integer::sum);
        }
        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            if (!charactersMap.containsKey(ch) || charactersMap.get(ch) == 0) {
                return false;
            }
            charactersMap.merge(ch, -1, Integer::sum);
        }
        return true;
    }
}
