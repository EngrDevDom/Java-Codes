package StringPermutations.WithDups;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * sol = O(n!)
 */
public class sol {

    public static ArrayList<String> getPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    public static HashMap<Character, Integer> buildFreqTable(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        return map;
    }

    public static void printPerms(HashMap<Character, Integer> map
    ,String prefix, int remaining, ArrayList<String> result){
        if(remaining == 0){
            result.add(prefix);
            return;
        }

        for(Character c : map.keySet()){
            int count = map.get(c);
            if(count > 0){
                map.put(c,count - 1);
                printPerms(map, prefix+c, remaining-1, result);
                map.put(c, count);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> perms = getPerms("ttrruuee");
        System.out.println(perms.size());
        for (String s : perms) {
            System.out.print(s+" ");
        }
    }
}