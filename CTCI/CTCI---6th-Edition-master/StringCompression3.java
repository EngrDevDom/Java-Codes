import java.util.Scanner;

public class StringCompression3 {
        public static void main(String[] args) {
            StringCompression3 sc  = new StringCompression3();
            Scanner i = new Scanner(System.in);
            String c = i.next();
            i.close();
            String m = sc.compress(c);
            System.out.println(m);
        }

        String compress(String s){
            int count = 0;
            int finalLength = compCapacity(s);
            if(finalLength > s.length()){
                return s;
            }

            StringBuilder sb = new StringBuilder(finalLength); //capacity of arraylist


            for(int i = 0; i < s.length(); i++){
                count++;

                if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
                    sb.append(s.charAt(i));
                    sb.append(count);
                    count = 0;

                }

            }
            return sb.toString();
        }

        int compCapacity(String s){
            int count = 0;
            int compressedLength = 0;

            for(int i = 0; i < s.length(); i++){ 
                count++;
                if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
                compressedLength += 1 + String.valueOf(count).length();
                count = 0;
                }
            }
            
            return compressedLength;
        }
}