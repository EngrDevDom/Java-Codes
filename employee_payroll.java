import java.util.Scanner; //program uses class SCanner

public class PayrollPart2
{

    public static void main( String[] args ) 
    {
        Scanner input = new Scanner( System.in ); // create Scanner to obtain input from command window

        // variables
        char name; // divisions's name
        int number1; // number of employees in the division
        double number2; // average salary for the employees
        double product; // total division payroll

            //prompt user to input division name
            System.out.print( "Enter Division's name, type stop to exit: ");
            String divisionName = input.nextLine(); //read line of text
                while (divisionName !="stop") 
                {
                //prompt user for number of employees in the division
                System.out.print( "Enter the number of employees in the division: ");
                //read number of employees from user's input
                number1 = input.nextInt();
                    while (number1 <= 0)
                    {
                        System.out.print("Please enter a positive number of employees in the division:"); // prompt
                        number1 = input.nextInt(); // input
                    }

                //prompt user to enter average salary of employees
                System.out.print("Enter average salary for the employees: " );
                //read average salary
                number2 = input.nextDouble();
                    while (number2 <= 0)
                    {
                        System.out.print("Please enter a positive number for the employees salary:"); // prompt
                        number2 = input.nextDouble(); // input
                    }

                //multiply Number1 by Number2
                product = number1 * number2;

                //displays division and total division payroll
                System.out.printf( "The division %s has a payroll of $%.2f\n" , divisionName, product );
                }
    } //end method main
} // end class PayrollPart2

