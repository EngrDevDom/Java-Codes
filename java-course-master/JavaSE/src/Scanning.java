//import java.io.*;
import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three integer values: ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();

        System.out.println("The value is: " + (i+j+k) / 3);
        System.out.println();
    }


}
