import java.util.Scanner;
import java.security.SecureRandom;

public class CAI1
{
    private static Scanner input = new Scanner(System.in);
    private static SecureRandom number = new SecureRandom();

    public static void quiz()
    {
        int num1 = number.nextInt(10);
        int num2 = number.nextInt(10);

        while (true)
        {
            askQuestion(num1, num2);
            if (readResponse() == isAnswerCorrect(num1, num2))
                break;
            displayIncorrectResponse();
        }
        displayCorrectResponse();
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
        System.out.println("Very good!");
    }

    public static void displayIncorrectResponse()
    {
        System.out.println("No. Please try again.");
    }

    public static void main(String[] args)
    {
	    quiz();
    }
}
