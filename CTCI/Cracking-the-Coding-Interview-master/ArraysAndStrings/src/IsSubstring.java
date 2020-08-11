public class IsSubstring {

    public static boolean isSubstring(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        for(int i=0;i<=m-n;i++){
            int j;
            for(j=0;j<n;j++){
                if(s1.charAt(i+j) != s2.charAt(j)){
                    break;
                }
            }
            if(j==n){
                return true;
            }
        }
        return false;
    }

    public static boolean isRotation(String s1, String s2){
        int len = s1.length();
        if(s2.length() == len && len > 0){
            String s1s1 = s1+s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "water";
        String s2 = "terwa";

        System.out.println(isRotation(s1,s2));
    }
}
