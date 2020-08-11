import java.util.HashSet;
import java.util.Set;

public class Parenthesis {

    public static Set<String> generateParens(int rem) {
        Set<String> set = new HashSet<>();
        if(rem == 0){
            set.add("");
        }else{
            Set<String> prev = generateParens( rem -1);
            for(String str : prev){
                for(int i = 0;i<str.length();i++){
                    if(str.charAt(i) == '('){
                        String s = insertInside(str,i);
                        set.add(s);
                    }
                }
                set.add("()"+str);
            }
        }
        return set;
    }

    public static String insertInside(String str, int leftIndex) {
        String left = str.substring(0,leftIndex+1);
        String right = str.substring(leftIndex+1, str.length());
        return left+"()"+right;
    }
    public static void main(String[] args) {
        Set<String> s = generateParens(4);
        for(String list : s){
            System.out.println(list);
        }
    }
}