package _101_Is_Unique;

import java.util.HashSet;



/**
 *   Class to check if string str is composed from uniques characters
 *
 */
public class IsStringComposedFromUniqueChars {

    private static final int NUMBER_OF_ASCII_CHARS = 256;

    public static boolean areUniqueCharacters(String str) {
        if (str.length() > NUMBER_OF_ASCII_CHARS) {
            return false;
        }
        HashSet<Character> charSet = new HashSet(NUMBER_OF_ASCII_CHARS);
        for (int i = 0; i < str.length(); i++) {
            if (charSet.contains(str.charAt(i))) {
                return false;
            } else {
                charSet.add(str.charAt(i));
            }
        }
        return true;
    }
}
