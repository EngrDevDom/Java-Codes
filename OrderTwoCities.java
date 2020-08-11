import java.util.Scanner;

public class OrderTwoCities {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two cities
        System.out.print("Enter the first city: ");         // input city 1
        String city1 = input.nextLine();

        System.out.print("Enter the second city: ");        // input city 2
        String city2 = input.nextLine();

        if (city1.compareTo(city2) < 0)                     // compare two cities
            System.out.println("The cities in alphabet order are " + city1 + " " + city2);
        else
            System.out.println("The cities in alphabet order are " + city2 + " " + city1);

    }    
}
