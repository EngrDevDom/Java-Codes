import java.util.Scanner;
import java.security.SecureRandom;

public class CAI4
{
    private static Scanner input = new Scanner(System.in);
    private static SecureRandom number = new SecureRandom();
    private static int num1, num2;

    public static void quiz()
    {
        int i, difficulty, counter = 0;

        difficulty = readDifficulty();
        for (i = 1; i <= 10; i++)
        {
            generateQuestionArgument(difficulty);
            askQuestion(num1, num2);
            if (readResponse() == isAnswerCorrect(num1, num2))
            {
                displayCorrectResponse();
                counter++;
            }
            else
                displayIncorrectResponse();
        }
        displayCompletionMessage(counter);
    }

    public static void askQuestion(int num1, int num2)
    {
        System.out.printf("How much is %d times %d: ", num1, num2);
        System.out.println();
    }

    public static int readResponse()
    {
        return input.nextInt();
    }

    public static int isAnswerCorrect(int num1, int num2)
    {
        return num1 * num2;
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

    public static void displayCompletionMessage(int numCorrect)
    {
        final int numQuestions = 10;
        double percentage = (double)numCorrect / numQuestions;

        System.out.printf("Score = %.0f%%", percentage * 100);
        System.out.println();
        if (percentage < 0.75)
            System.out.println("Please ask your teacher for extra help.");
        else
            System.out.println("Congratulations, you are ready to go to the next level!");
    }

    public static int readProblemType()
    {
        System.out.println("Arithmetic Problems");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Please select an option: ");

        return input.nextInt();
    }

    public static int readDifficulty()
    {
        System.out.print("Please enter a difficulty level 1-4: ");
        return input.nextInt();
    }

    public static void generateQuestionArgument(int difficulty)
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
    }

    public static void main(String[] args)
    {
        quiz();
    }
}

