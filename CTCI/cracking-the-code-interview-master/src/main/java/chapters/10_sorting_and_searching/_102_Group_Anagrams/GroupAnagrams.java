package _102_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */
public class GroupAnagrams {

    public static void groupAnagrams(String[] strings) {

        HashMap<String, List<String>> stringMap = new HashMap();

        for (String s : strings) {
            String key = sortChars(s);
            stringMap.putIfAbsent(key, new ArrayList<String>());
            List<String> anagrams = stringMap.get(key);
            anagrams.add(s);
        }

        int index = 0;
        for (List<String> list : stringMap.values()) {
            for (String s : list) {
                strings[index++] = s;
            }
        }
    }

    private static String sortChars(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
