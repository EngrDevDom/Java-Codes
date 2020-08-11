package _102_Group_Anagrams;

import java.util.Arrays;

public class TesterClass {

    public static void main(String[] args) {
        String[] strings = {"aba", "ab", "ba", "abc", "baaa", "ccca", "bob", "bar", "rab"};
        GroupAnagrams.groupAnagrams(strings);
        System.out.println("Anagrams: " + Arrays.toString(strings) + "\n");
    }
}
