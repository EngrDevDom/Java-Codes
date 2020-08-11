import java.util.*;

public class BinarytoString {

    public static String printBinary(double n){
        if (n >= 1 || n <=0){
            return "Error";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(n>0){
            if(binary.length() > 32){
                return "Error";
            }
            double r = n * 2;
            if(r >= 1){
                binary.append(1);
                n = r - 1;
            }else{
                binary.append(0);
                n = r;
            }

        }
        return binary.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        sc.close();
        String s = printBinary(n);
        System.out.println(s);
    }
}