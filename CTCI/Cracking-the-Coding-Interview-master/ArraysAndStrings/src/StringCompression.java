import java.util.ArrayList;

public class StringCompression {

    public static String compressString(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == s.charAt(i-1)){
                count++;
            }else{
                sb.append(s.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        sb.append(s.charAt(s.length()-1));
        sb.append(count);

        String result = sb.toString();

        return s.length()>result.length() ? result : s;
    }

    public static int compress(char[] chars) {
        int anchor = 0, write = 0;

        for(int read = 0;read<chars.length;read++){
            if(chars[read] != chars[read+1] || read+1 == chars.length){
                chars[write] = chars[anchor];
                write++;
                if(read > anchor) //this condition takes care of 'abbbb' scenario where we want ab4 and not a1b4
                {
                    for (char ch : ("" + (read-anchor+1)).toCharArray()) {
                        chars[write] = ch;
                        write++;
                    }
                }
                anchor = read+1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        String s = "aaabbccccaa";
        System.out.println("Compressed string:");
        /*
        String ans = compressString(s);
        for(int i=0;i<ans.length();i++){
            System.out.print(ans.charAt(i));
        }

         */

        char[] chars = {'a','a','b','b','c','c','c'};

        System.out.println(compress(chars));
    }
}
