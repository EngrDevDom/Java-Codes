package com.company;

public class Decryptor
{
    static Application safeDigits = new Application();

    public static int decrypt(int safeData)
    {
        int unsafeData;
        int onesPlace;
        int tensPlace;
        int hundsPlace;
        int thousPlace;

        onesPlace = safeDigits.separateDigits(safeData, 1);
        tensPlace = safeDigits.separateDigits(safeData, 10);
        hundsPlace = safeDigits.separateDigits(safeData, 100);
        thousPlace = safeDigits.separateDigits(safeData, 1000);

        unsafeData = replaceWithDecryption(onesPlace, tensPlace, hundsPlace, thousPlace);
        return unsafeData;
    }

    // Replace each digit with the result of adding 10 and subtracting 7 (or just adding 3)
    public static int replaceWithDecryption(int ones, int tens, int hunds, int thous)
    {
        final int addValue = 3;
        final int modValue = 10;
        int finalValue = 0;

        ones = (ones + addValue) % modValue;
        tens = (tens + addValue) % modValue;
        hunds = (hunds + addValue) % modValue;
        thous = (thous + addValue) % modValue;

        finalValue += safeDigits.fakeSwap(tens, 1000) + safeDigits.fakeSwap(ones, 100);
        finalValue += safeDigits.fakeSwap(thous, 10) + safeDigits.fakeSwap(hunds, 1);

        return finalValue;
    }
}

