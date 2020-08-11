
import java.util.Scanner;

/**
 * StringCompression2
 */
public class StringCompression2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        StringCompression2 sc2 = new StringCompression2();
        String compressed = sc2.compress(s);
        System.out.println(compressed);
    }

    String compress(String str){
        
        StringBuilder cstr = new StringBuilder();

        int count = 0;
        for(int i=0; i<str.length(); i++){
            count++;

            if(i+1 > str.length() || str.charAt(i) != str.charAt(i+1)){
                cstr.append(str.charAt(i));
                cstr.append(count);
                count = 0;
            }
        }
        return cstr.length() < str.length() ? cstr.toString() : str;
    }
}