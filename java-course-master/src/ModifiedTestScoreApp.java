import java.util.Scanner;

public class ModifiedTestScoreApp {
    public static void main(String[] args) {
        System.out.println("Please enter test scores that range from 0 to 100.");
        System.out.println("To end the program enter 999.\n");

        double scoreTotal = .0;
        int scoreCount = 0;
        int testScore = 0;
        Scanner sc = new Scanner(System.in);

        while(testScore != 999) {
            System.out.println("Enter score: ");
            testScore = sc.nextInt();

            if(testScore < 100) {
                scoreCount ++;
                scoreTotal += testScore;
            }
            else if (testScore > 100)
                System.out.println("Invalid entry, not counted");
        }

        double averageScore = scoreTotal / scoreCount;
        String message = "Score count: " + scoreCount + "\n"
                + "Score total: " + scoreTotal + "\n"
                + "Average score: " + averageScore + "\n";

        System.out.println(message);

    }
}
