import java.util.HashMap;

public class PalindromePermutation {

    public static boolean canPermutePalindrome(String s){
        if(s.length() == 0){
            return true;
        }

        int countOdd = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char key: map.keySet()){
            int val = map.get(key);
            if(val%2 == 1){
                countOdd ++;
            }
        }
        if(countOdd>1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabbdf";
        System.out.println(canPermutePalindrome(s));
    }
}
