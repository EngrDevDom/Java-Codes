public class ConversionOfIntegers {
    public static void main(String[] args) {
        int a = 0;
        int b = (short) a + 46;
        byte c = (byte) (a * b);
        double f = (char) 1234.15;
        long d = (char) (a + f / c + b);
        System.out.println(d);
    }
}
