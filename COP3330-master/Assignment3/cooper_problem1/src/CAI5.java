import java.text.DecimalFormat;
import java.util.Scanner;
import java.security.SecureRandom;
import java.lang.Math;

public class CAI5
{
    private static Scanner input = new Scanner(System.in);
    private static SecureRandom number = new SecureRandom();
    private static int num1, num2, problemType;

    public static void quiz()
    {
        final int NUM_QUESTIONS = 10;
        int i, difficulty, counter, problem;

        while (true)
        {
            counter = 0;

            problem = readProblemType();
            difficulty = readDifficulty();
            for (i = 1; i <= NUM_QUESTIONS; i++)
            {
                generateQuestionArgument(difficulty, problem);
                problemType = (problem == 5) ? number.nextInt(4) + 1 : problem;
                askQuestion(num1, num2);
                if (Math.abs(isAnswerCorrect(num1, num2) - readResponse()) < 0.01)
                {
                    displayCorrectResponse();
                    counter++;
                }
                else
                    displayIncorrectResponse();
            }
            if (displayCompletionMessage(counter) == 2)
                break;
        }
    }

    public static void askQuestion(int num1, int num2)
    {
        switch (problemType)
        {
            case 1:
                System.out.printf("How much is %d plus %d: ", num1, num2);
                System.out.println();
                break;
            case 2:
                System.out.printf("How much is %d times %d: ", num1, num2);
                System.out.println();
                break;
            case 3:
                System.out.printf("How much is %d minus %d: ", num1, num2);
                System.out.println();
                break;
            case 4:
                System.out.printf("How much is %d divided by %d: ", num1, num2);
                System.out.println();
                break;

        }
    }

    public static double readResponse()
    {
        return input.nextDouble();
    }

    public static double isAnswerCorrect(int num1, int num2)
    {
        switch (problemType)
        {
            case 1:
                return num1 + num2;
            case 2:
                return num1 * num2;
            case 3:
                return num1 - num2;
            case 4:
                return (double)num1 / num2;
        }
        return -1.0;
    }

    public static void displayCorrectResponse()
    {
        int selection = number.nextInt(4) + 1;

        switch (selection)
        {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    public static void displayIncorrectResponse()
    {
        int selection = number.nextInt(4) + 1;

        switch (selection)
        {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don’t give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static int displayCompletionMessage(int numCorrect)
    {
        final int numQuestions = 10;
        double percentage = (double)numCorrect / numQuestions;

        System.out.printf("Score = %.0f%%", percentage * 100);
        System.out.println();
        if (percentage < 0.75)
            System.out.println("Please ask your teacher for extra help.");
        else
            System.out.println("Congratulations, you are ready to go to the next level!");

        System.out.println("Would you like to solve another problem set?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        return input.nextInt();
    }

    public static int readProblemType()
    {
        System.out.println("Arithmetic Problems");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Subtraction");
        System.out.println("4. Division");
        System.out.println("5. All of the above");
        System.out.print("Please select an option: ");

        return input.nextInt();
    }

    public static int readDifficulty()
    {
        System.out.print("Please enter a difficulty level 1-4: ");
        return input.nextInt();
    }

    public static void generateQuestionArgument(int difficulty, int problem) {
        while (true)
        {
            switch (difficulty)
            {
                case 1:
                    num1 = number.nextInt(10);
                    num2 = number.nextInt(10);
                    break;
                case 2:
                    num1 = number.nextInt(100);
                    num2 = number.nextInt(100);
                    break;
                case 3:
                    num1 = number.nextInt(1000);
                    num2 = number.nextInt(1000);
                    break;
                case 4:
                    num1 = number.nextInt(10_000);
                    num2 = number.nextInt(10_000);
                    break;
            }
            if (num2 != 0 || problem != 4)
                break;
        }
    }

    public static void main(String[] args)
    {
        quiz();
    }
}

