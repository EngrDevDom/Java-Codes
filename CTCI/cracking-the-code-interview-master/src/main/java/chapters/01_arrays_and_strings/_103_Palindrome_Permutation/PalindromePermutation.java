package _103_Palindrome_Permutation;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    private static final int LOWER_CASE_LETTERS = 26;

    public static boolean palindromePermutation(String word) {
        word = word.toLowerCase().replaceAll("\\s", "");
        Map<Character, Integer> characterIntegerMap = new HashMap(LOWER_CASE_LETTERS);
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                characterIntegerMap.merge(ch, 1, Integer::sum);
            }
        }
        int oddCharacterCount = 0;
        for (Integer value : characterIntegerMap.values()) {
            if (value % 2 != 0) {
                oddCharacterCount++;
            }
            if (oddCharacterCount > 1) {
                return false;
            }
        }
        return true;
    }
}
