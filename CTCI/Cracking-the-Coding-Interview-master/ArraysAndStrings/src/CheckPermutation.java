import java.util.Arrays;

public class CheckPermutation {

    public static String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        //System.out.println(new String(arr));
        return new String(arr);
    }

    public static boolean checkPermutationSort(String s,String r){
        if(s.length() != r.length()){
            return false;
        }
        return sort(s).equals(sort(r));
    }

    public static boolean checkPermutationArray(String s,String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] letters = new int[128];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            letters[c] ++ ;
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            letters[c]--;
            if(letters[c]<0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "abc";
        String r = "bac";
        //System.out.println(checkPermutationSort(s,r));
        System.out.println(checkPermutationArray(s,r));
    }
}
