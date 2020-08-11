package StringPermutations.WithoutDups;

import java.util.ArrayList;

public class SecondApproach {

    public static ArrayList<String> getPerms(String str) {
        int len = str.length();
        ArrayList<String> result = new ArrayList<>();

        //Base case
        if(len == 0){
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            String before = str.substring(0, i);
            String after = str.substring(i+1,len);
            ArrayList<String> partials = getPerms(before + after);

            for(String s : partials){
                result.add(str.charAt(i) + s);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<String> perms = getPerms("true");
        for(String s : perms){
            System.out.println(s);
        }
    }
}