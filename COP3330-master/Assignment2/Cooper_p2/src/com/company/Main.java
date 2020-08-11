package com.company;

public class Main
{
    public static void main(String[] args)
    {
        BMICalculator app = new BMICalculator();
        app.readUserData();
        app.calculateBmi();
        app.displayBmi();
    }
}

