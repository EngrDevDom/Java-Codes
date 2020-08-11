package StringPermutations.WithoutDups;

import java.util.ArrayList;

public class Firstnapproach {

    public static ArrayList<String> getPerms(String str){
        if(str == null) return null;

        ArrayList<String> permutations = new ArrayList<String>();
        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word,first,i);
                permutations.add(s);
            }
        }
        return permutations;
    }
    
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        ArrayList<String> perms = getPerms("true");
        System.out.println(perms.size());
        for (String s : perms ){
            System.out.println(s);
        }
    }
}