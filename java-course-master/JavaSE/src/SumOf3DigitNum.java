public class SumOf3DigitNum {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int a;
        a = number/100 + (number/10)%10 + number % 10;
        return a;
    }
}
