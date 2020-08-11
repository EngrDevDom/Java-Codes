import java.util.*;

public class WeeklyWages {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        double hrsworked, payrate, wages;

        System.out.print("Enter working hours: ");
        hrsworked = console.nextDouble();

        System.out.println();

        System.out.print("Enter the payrate: ");
        payrate = console.nextDouble();

        System.out.println();

        if (hrsworked > 40)
            wages = 40.0 * payrate + 1.5 * payrate * (hrsworked - 40.0);
        else
            wages = hrsworked * payrate;

        System.out.printf("Hours worked = .2%f %n", wages);
        System.out.println();

    }
}