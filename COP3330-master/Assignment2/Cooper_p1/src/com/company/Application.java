package com.company;

/*
 * A company that wants to send data over the Internet has asked you to write a program
 * 		that will encrypt it so that it may be transmitted more securely.
 *
 * All the data is transmitted as four-digit integers.
 * Your application should read a four-digit integer entered by the user
 * 		Encrypt it as follows:
 * 			Replace each digit with the result of adding 7 and getting the remainder after dividing by 10.
 * 			Then swap the first digit with the third, and swap the second digit with the fourth.
 * 			Then print the encrypted integer.
 *
 * Your application should also allow the user to enter an encrypted four-digit integer
 * 		and then decrypt it (by reversing the encryption scheme) to form the original number.
 */

import java.util.Scanner;

public class Application
{
    public static Scanner input = new Scanner(System.in);

    // Your application should read a four-digit integer entered by the user
    public static int getInput(String prompt)
    {
        final int lowerBound = 0;
        final int upperBound = 9999;
        int data = -1;
        boolean validInput = false;

        while (!validInput)
        {
            System.out.print(prompt);
            data = input.nextInt();

            if (data >= lowerBound && data <= upperBound)
                validInput = true;
            else
                System.out.println("That is not a valid input.");
        }
        return data;
    }

    public static int menu()
    {
        int menuSelection = -1;
        boolean validOption = false;

        while(!validOption)
        {
            System.out.println("Please select an option...");
            System.out.println("1. Encrypt a number");
            System.out.println("2. Decrypt a number");
            System.out.println("3. Quit");

            menuSelection = input.nextInt();

            if (menuSelection == 1 || menuSelection == 2 || menuSelection == 3)
                validOption = true;
            else
                System.out.println("That is not a valid selection");
        }
        return menuSelection;
    }

    // acts as a swap function and makes the digit the appropriate multiple
    public int fakeSwap(int replacingDigit, int multiple)
    {
        int newDigit = replacingDigit * multiple;

        return newDigit;
    }

    // this function takes an int (data) and divides and mods
    // the value to get a particular digit from the full number
    public int separateDigits(int data, int divideBy)
    {
        data /= divideBy;
        data %= 10;
        return data;
    }

    public static void main(String[] args)
    {
        int data;
        int safeData;
        int decryptedData;
        int menuOption;

        menuOption = menu();

        switch (menuOption)
        {
            case 1:
                data = getInput("Please enter a positive four digit whole number: ");
                safeData = Encryptor.encrypt(data);
                System.out.printf("Your encrypted number is %04d", safeData);
                System.out.println("");
                break;
            case 2:
                data = getInput("Please enter a positive four digit whole number: ");
                decryptedData = Decryptor.decrypt(data);
                System.out.printf("Your decrypted number is %04d", decryptedData);
                System.out.println("");
                break;
            case 3:
                System.out.println("Quitting...");
                break;
        }
        input.close();
    }
}

