import java.util.ArrayList;
import java.util.Scanner;

public class NameParserApp {
    public static void main(String[] args) {
        String[] fullName;
//        String[] formatName = new String[0];
        ArrayList<String> formatName = new ArrayList<String>();
//        StringBuilder sb = new StringBuilder();
//        String[] prompt = new String[0];
        String s = "";
        Scanner sc = new Scanner(System.in);

//        System.out.println(fullName.length);

        while (true) {
            System.out.println("Enter your name: ");
            s = sc.nextLine();
            s = s.trim();
            int index = s.indexOf(" ");

            fullName = s.split(" ");
            if (fullName.length < 2 || fullName.length > 3 || index == -1)
                System.out.println("The name should consists of two or three parts. Try again");
            else {
                break;
            }
        }

        formatName.add("First name: " + fullName[0]);

        if (fullName.length == 2) {
            formatName.add(1,"Last Name:   " + fullName[1]);
        } else {
            formatName.add(1,"Middle Name: " + fullName[1]);
            formatName.add(2,"Last Name:   " + fullName[2]);
        }

        for (int i = 0; i < formatName.size(); i ++)
            System.out.println(formatName.get(i));
    }
}
