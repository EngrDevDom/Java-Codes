import java.util.Scanner;

public class SimpleIfDemo {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");     // enter input
        int number = input.nextInt();

        if (number % 5 == 0)                        // check five
            System.out.println("HiFive");

        if (number % 2 == 0)                        // check even
            System.out.println("HiEven");

    }
}
