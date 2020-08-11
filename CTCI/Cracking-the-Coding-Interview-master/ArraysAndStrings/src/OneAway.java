
public class OneAway {

    public static boolean oneEditReplace(String s1, String s2){
        boolean foundDiff = false;
        for(int i=0;i< s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDiff){
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;

        while(index1<s1.length() && index2<s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index1++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean isOneEditDistance(String s, String t){
        if(s.length() == t.length()){
            return oneEditReplace(s,t);
        }
        if(s.length() > t.length()){
            return oneEditInsert(s,t);
        }
        return oneEditInsert(t,s);
    }

    public static void main(String[] args) {
        String s = "ple";
        String t = "pale";

        System.out.println(isOneEditDistance(s,t));
    }
}
