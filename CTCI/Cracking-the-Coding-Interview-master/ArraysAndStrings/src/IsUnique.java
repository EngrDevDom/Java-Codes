public class IsUnique {

    public static boolean isUnique(String s){

        boolean[] char_set = new boolean[128];
        for(int i=0;i<s.length();i++){
             int val = s.charAt(i) - 'a';
             if(char_set[val]){
                 return false;
             }
             char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcb";
        System.out.println(isUnique(s));
    }
}
/*

    public int firstUniqChar(String s) {
        Map <Character, Integer> hashmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            hashmap.put(c, hashmap.getOrDefault(c,0)+1);
        }
        for (int i=0; i<s.length();i++){
            if(hashmap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;


    }

 */