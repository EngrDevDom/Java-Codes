import java.text.NumberFormat;
import java.util.Scanner;

public class ValidatedTestScoreApp {
    public static void main(String[] args) {
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int maximum = 0;
        int minimum = 1000;

        Scanner sc = new Scanner(System.in);
        String choise = "y";
        do {
            System.out.print("Enter the number of test scores to be entered: ");
            int numberOfTestScores = sc.nextInt();
            for(int i = 1; i < numberOfTestScores + 1; i ++) {
                String message = prompt(i);
                testScore = getIntWithRange(sc, message, 5, 35);
                scoreCount++;
                scoreTotal += testScore;
                maximum = Math.max(testScore, maximum);
                minimum = Math.min(testScore, minimum);
            }
            double averageScore = (double)scoreTotal / (double)scoreCount;

            NumberFormat number = NumberFormat.getNumberInstance();
            number.setMaximumFractionDigits(1);
            String fnumber = number.format(averageScore);

            String fmessage = "\nScore count: " + scoreCount + "\n"
                    + "Score total: " + scoreTotal + "\n"
                    + "Average score: " + fnumber + "\n";

            String message2 = "Maximum is: " + maximum + "\n"
                    + "Minimum is: " + minimum + "\n";

            System.out.println(fmessage);
            System.out.println(message2);
            System.out.println("Enter more test scores? (y/n): ");
            choise = sc.next();
            if(choise.equalsIgnoreCase("y")) {
                scoreCount = 0;
                scoreTotal = 0;
                averageScore = 0.;
                maximum = 0;
                minimum = 1000;
            }
            sc.nextLine();
            System.out.println();
        } while(!choise.equalsIgnoreCase("n"));
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.println(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            }
            else
                System.out.println("Error! Invalid integer value. Try again.");
            sc.nextLine();
        }
        return i;
    }

    public static int getIntWithRange(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println("Error! Number must be greater than " + min + ".");
                System.out.println("Invalid entry, not counted");
                i--;
            }
            else if (i >= max) {
                System.out.println("Error! Number must be less than " + max + ".");
                System.out.println("Invalid entry, not counted");
                i--;
            }
            else
                isValid = true;
        }
        return i;
    }

    public static String prompt( int k) {
        String begin = "Enter score ";
        String end = ": ";
        return begin + k + end;
    }

}
