import java.util.Scanner;
import java.security.SecureRandom;

public class CAI3
{
    private static Scanner input = new Scanner(System.in);
    private static SecureRandom number = new SecureRandom();

    public static void quiz()
    {
        int i, counter = 0;

        for (i = 1; i <= 10; i++)
        {
            int num1 = number.nextInt(10);
            int num2 = number.nextInt(10);

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
        int answer = input.nextInt();
        return answer;
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

        System.out.printf("Score = %f", percentage * 100);
        System.out.println();
        if (percentage < 0.75)
            System.out.println("Please ask your teacher for extra help.");
        else
            System.out.println("Congratulations, you are ready to go to the next level!");
    }

    public static void main(String[] args)
    {
        quiz();
    }
}

