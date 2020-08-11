package StringRotation;


public class Substring {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "elttobaater";

        boolean flag =false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if(c2[j] == c1[i]){
                    c2[j] = '\0';
                    c1[i] = '\0';
                }
            }
        }

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if(c2[j] == '\0'){
                    flag = true;
                }
                else{
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);
    }
}