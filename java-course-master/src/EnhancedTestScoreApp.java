import java.text.NumberFormat;
import java.util.Scanner;

public class EnhancedTestScoreApp {
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
                System.out.print("Enter score " + i + ": ");
                testScore = sc.nextInt();

                if(testScore > 100 || testScore < 0) {
                    System.out.println("Invalid entry, not counted");
                    i--;
                }
                else if(testScore <= 100) {
                    scoreCount ++;
                    scoreTotal += testScore;
                    maximum = Math.max(testScore, maximum);
                    minimum = Math.min(testScore, minimum);
                }
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
        } while(!choise.equalsIgnoreCase("n"));
    }
}