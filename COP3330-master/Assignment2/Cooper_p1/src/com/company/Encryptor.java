package com.company;


public class Encryptor
{
    static Application unsafeDigits = new Application();

    // Replace each digit with the result of adding 7 and getting the remainder after dividing by 10.
    public static int replaceWithEncryption(int ones, int tens, int hunds, int thous)
    {
        final int addValue = 7;
        final int modValue = 10;
        int finalValue = 0;

        ones = (ones + addValue) % modValue;
        tens = (tens + addValue) % modValue;
        hunds = (hunds + addValue) % modValue;
        thous = (thous + addValue) % modValue;

        finalValue += unsafeDigits.fakeSwap(tens, 1000) + unsafeDigits.fakeSwap(ones, 100);
        finalValue += unsafeDigits.fakeSwap(thous, 10) + unsafeDigits.fakeSwap(hunds, 1);

        return finalValue;
    }

    public static int encrypt(int unsafeData)
    {
        int safeData;
        int onesPlace;
        int tensPlace;
        int hundsPlace;
        int thousPlace;

        onesPlace = unsafeDigits.separateDigits(unsafeData, 1);
        tensPlace = unsafeDigits.separateDigits(unsafeData, 10);
        hundsPlace = unsafeDigits.separateDigits(unsafeData, 100);
        thousPlace = unsafeDigits.separateDigits(unsafeData, 1000);

        safeData = replaceWithEncryption(onesPlace, tensPlace, hundsPlace, thousPlace);
        return safeData;
    }
}

