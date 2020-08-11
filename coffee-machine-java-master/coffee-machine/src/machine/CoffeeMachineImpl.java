package machine;

import java.util.Scanner;

public class CoffeeMachineImpl {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;
    private Scanner scanner = new Scanner(System.in);

    public CoffeeMachineImpl() {
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cups = 9;
        this.money = 550;
    }

    private void print() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", this.water);
        System.out.printf("%d of milk\n", this.milk);
        System.out.printf("%d of coffee beans\n", this.coffee);
        System.out.printf("%d of disposable cups\n", this.cups);
        System.out.printf("%d of money\n", this.money);
    }

    private int getBuyInput() {
        int buy;
        String buyOption;

        do {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            buyOption = scanner.nextLine();
            if (buyOption.equals("back")) {
                return 0;
            } else {
                buy = Integer.parseInt(buyOption);
                if (buy < 1 || buy > 3) {
                    System.out.println("Invalid option! Type: 'back' to cancel this buy operation!");
                }
            }
        } while (buy < 1 || buy > 3);

        return buy;
    }

    enum BuyCaseCode {
        BACK(0),
        ESPRESSO(1),
        LATTE(2),
        CAPPUCCINO(3);

        int option;

        BuyCaseCode(int option) {
            this.option = option;
        }

        int getOption() {
            return this.option;
        }
    }

    private int[] getIngredients(int option) {
        // return { waterSize, milkSize, coffeeSize, cupSize, moneyValue };
        if (option == BuyCaseCode.ESPRESSO.getOption()) {
            return new int[] {
                    250, 0, 16, 0, 4
            };
        } else if (option == BuyCaseCode.LATTE.getOption()) {
            return new int[] {
                    350, 75, 20, 0, 7
            };
        } else if (option == BuyCaseCode.CAPPUCCINO.getOption()) {
            return new int[] {
                    200, 100, 12, 0, 6
            };
        }

        return new int[] {};
    }

    public void process(String option) {
        switch (option) {
            case "buy":
                int buy = this.getBuyInput();

                if (buy == BuyCaseCode.BACK.getOption()) {
                    return;
                }

                int[] ingredients = this.getIngredients(buy);
                if (water >= ingredients[0] && milk >= ingredients[1] && coffee >= ingredients[2] && cups > ingredients[3]) {
                    water -= ingredients[0];
                    milk -= ingredients[1];
                    coffee -= ingredients[2];
                    money += ingredients[4];
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < ingredients[0]) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < ingredients[1]) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffee < ingredients[2]) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (cups == ingredients[3]) {
                    System.out.println("Sorry, not enough cup!");
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                int input = Integer.parseInt(scanner.nextLine());
                this.water += input;
                System.out.println("Write how many ml of milk do you want to add: ");
                input = Integer.parseInt(scanner.nextLine());
                this.milk += input;
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                input = Integer.parseInt(scanner.nextLine());
                this.coffee += input;
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                input = Integer.parseInt(scanner.nextLine());
                this.cups += input;
                break;
            case "take":
                System.out.printf("I gave you $%d\n", money);
                this.money = 0;
                break;
            case "remaining":
                this.print();
                break;
            case "exit":
                // Do nothing! This program will exit soon!
                break;
            default:
                System.out.println("Invalid option for the Coffee Machine!");
                break;
        }
    }
}
