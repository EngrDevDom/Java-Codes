package com.company;

import java.util.Scanner;

public class BMICalculator
{
    Scanner input = new Scanner(System.in);
    private double userHeight;
    private double userWeight;
    private String unitType;
    private double userBmi;
    private String userBmiCategory;
    /*
     * Create a BMI calculator that reads the user’s weight and height
     * 		(providing an option for the user to select which formula to use),
     * 		and then calculates and displays the user’s body mass index.
     *
     * Also, display the BMI categories and their values from the National Heart Lung
     * 		and Blood Institute:
     */

    /*
    This program should prompt the user to pick imperial or metric units
        Should continue to ask for input until the user enters a valid selection
    The program will get the users height and weight and calculate their BMI and BMI category
    The program will print the results along with the category chart
     */
    public String getUnitType()
    {
        return unitType;
    }

    private void setUnitType(String type)
    {
        unitType = type;
    }

    public double getWeight()
    {
        return userWeight;
    }

    private void setWeight(double weight)
    {
        userWeight = weight;
    }

    public double getHeight()
    {
        return userHeight;
    }

    public void setHeight(double height)
    {
        userHeight = height;
    }

    public double getBmi()
    {
        return userBmi;
    }

    private void setBmi(double bmi)
    {
        userBmi = bmi;
    }

    public String getBmiCategory()
    {
        return userBmiCategory;
    }

    public void readUserData()
    {
        //  use readUnitType and readMeasurementData
        boolean validInput = false;
        int menuOption = 0;
        String type = null;

        while (!validInput)
        {
            System.out.println("Please select an option:");
            System.out.println("1. Calculate BMI using Imperial Data");
            System.out.println("2. Calculate BMI using Metric Data");

            menuOption = input.nextInt();

            if (menuOption == 1 || menuOption == 2)
                validInput = true;
            else
                System.out.println("That is not a valid input.");

        }

        type = readUnitType(menuOption);
        unitType = type;
        readMeasurementData(type);
    }

    private String readUnitType(int menuOption)
    {
        if (menuOption == 1)
            return "Imperial";
        return "Metric";
    }

    private void readMeasurementData(String unitType)
    {
//		calls either readMetricData or readImperialData
        if (unitType.equals("Imperial"))
            readImperialData();
        else
            readMetricData();
    }

    private void readMetricData()
    {
        double height;
        double weight;

        System.out.print("Please enter your height in meters: ");
        height = input.nextFloat();
        if (height < 0)
            System.exit(-1);
        setHeight(height);

        System.out.print("Please enter your weight in kilograms: ");
        weight = input.nextFloat();
        if (weight < 0)
            System.exit(-1);
        setWeight(weight);
    }

    private void readImperialData()
    {
        double height;
        double weight;

        System.out.print("Please enter your height in inches: ");
        height = input.nextFloat();
        if (height < 0)
            System.exit(-1);
        setHeight(height);

        System.out.print("Please enter your weight in pounds: ");
        weight = input.nextFloat();
        if (weight < 0)
            System.exit(-1);
        setWeight(weight);
    }

    public void calculateBmi()
    {
        final int IMPERIAL_MULTIPLIER = 703;
        double height = getHeight();
        double weight = getWeight();
        String unitType = getUnitType();
        double bmi;

        if (unitType.equals("Imperial"))
        {
            bmi = (IMPERIAL_MULTIPLIER * weight) / (height * height);
        }
        else
        {
            bmi = (weight) / (height * height);
        }

        userBmi = bmi;
        calculateBmiCategory(bmi);
    }

    private void calculateBmiCategory(double bmi)
    {
        final double UNDERWEIGHT = 18.5;
        final double NORMAL = 24.95;
        final double OVERWEIGHT = 29.95;

        if (bmi < UNDERWEIGHT)
            userBmiCategory = "underweight";
        else if (bmi < NORMAL)
            userBmiCategory = "normal";
        else if (bmi < OVERWEIGHT)
            userBmiCategory = "overweight";
        else
            userBmiCategory = "obese";
    }

    public void displayBmi()
    {
        System.out.printf("Your BMI is %.1f", getBmi());
        System.out.println();
        System.out.printf("Your BMI Category is %s", getBmiCategory());
        System.out.println();
        System.out.println();
        System.out.println("Underweight: <18.5");
        System.out.println("Normal: 18.5 – 24.9");
        System.out.println("Overweight: 24.5 – 29.9");
        System.out.println("Obesity: 30 or greater");
    }
}

