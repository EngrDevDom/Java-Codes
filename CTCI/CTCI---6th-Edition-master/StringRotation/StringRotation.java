package StringRotation;

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle","erbottlewat"));
        System.out.println(isRotation("myegg","eggmy"));
        System.out.println(isRotation("mylove", "loveme"));
    }

    static boolean isRotation(String s1, String s2){
        int len =s1.length();

        if(len != s2.length() || len <= 0){
            return false;
        }

        String str = s1+s1;
        return isSubString(str,s2);
    }

    static boolean isSubString(String str, String subStr){
        return str.contains(subStr);
    }
}