package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = "";
        String buyOption = "";
        int input = 0;
        int buy = 0;
        CoffeeMachineImpl machine = new CoffeeMachineImpl();

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            option = scanner.nextLine();
            machine.process(option);
        } while (!option.equals("exit"));
    }
}
