import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class BDTestScoreApp {
    public static void main(String[] args) {
        System.out.println("Please enter test scores that range from 0 to 100.");
        System.out.println("To end the program enter 999.\n");

//        double scoreTotal = .0; //the original one
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int maximum = 0;
        int minimum = 1000;

        Scanner sc = new Scanner(System.in);

        while(testScore != 999) {
            System.out.println("Enter score: ");
            testScore = sc.nextInt();

            if(testScore <= 100) {
                scoreCount ++;
                scoreTotal += testScore;
                maximum = Math.max(testScore, maximum);
                minimum = Math.min(testScore, minimum);
            }
            else if (testScore > 100) {
                if (testScore == 999)
                    break;
                System.out.println("Invalid entry, not counted");
            }
        }

        double averageScore = (double)scoreTotal / (double)scoreCount;

        BigDecimal decimalAverageScore = new BigDecimal(Double.toString(averageScore));
        decimalAverageScore = decimalAverageScore.setScale(2, RoundingMode.HALF_UP);

        String bmessage = "\nScore count: " + scoreCount + "\n"
                        + "Score total: " + scoreTotal + "\n"
                        + "Average score: " + decimalAverageScore + "\n";

        String message2 = "Maximum is: " + maximum + "\n"
                        + "Minimum is: " + minimum + "\n";

        System.out.println(bmessage);
        System.out.println(message2);
    }
}
