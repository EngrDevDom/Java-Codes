import java.util.Scanner;

public class AdditionQuiz {
    public static void main(String[] args) {

    int number1 = (int)(System.currentTimeMillis() % 10);           // generate number 1
    int number2 = (int)(System.currentTimeMillis() / 10 % 10);      // generate number 2

    // Create a Scanner
    Scanner input = new Scanner(System.in);

    System.out.print("What is " + number1 + " + " + number2 + "? ");     // show question
    int answer = input.nextInt();

    System.out.println(number1 + " + " + number2 + " = " + answer + " is " + (number1 + number2 == answer));    // display result

    }
}
