import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTestApp {
    public static void main(String[] args) {
        double[] dnumber = new double[99];
        for (int i = 0; i < 99; i ++)
            dnumber[i] = (Math.random() * 100);  // num is >= 0 and <= 100
        double total = 0.;
        for (double number : dnumber) {
            total += number;
        }
        System.out.println("Total:                        " + total);
        System.out.println("Average:                      " + total / dnumber.length);
        Arrays.sort(dnumber);
        System.out.println("The 50th value of array is:   " + dnumber[50]);
        for (int i = 9; i < dnumber.length; i +=9)
            System.out.println(i + "th value of array: " + dnumber[i]);
    }
}
