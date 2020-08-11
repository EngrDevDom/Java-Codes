import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class DownloadTimeApp {
    private String name;
    private int age;

    public DownloadTimeApp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Invoice Total Calculator\n");
        System.out.println("This program calculates how long it will take to\n" +
                           "download a file with a 56K analog modem." );

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
//        long hour;
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter file size (MB): " );
            double byt = sc.nextDouble();

            byt = byt * 1000000 * 1024;
            long kbyt = 1024 * 5200;
            long seconds = (long)byt / kbyt;


            long hour = seconds / 3600;
            long tmins = seconds % 3600;
            long mins = tmins / 60;
            long sec = tmins % 60;


            String message = "A \"56K\" modem will take "
                           + hour + " hours " + mins + " minutes " + sec + " seconds\n";

            System.out.println(message);

            System.out.println("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }

}
