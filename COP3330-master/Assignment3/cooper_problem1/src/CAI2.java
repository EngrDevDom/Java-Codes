import java.util.Scanner;
import java.security.SecureRandom;

public class CAI2
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

    public static void main(String[] args)
    {
        quiz();
    }
}

