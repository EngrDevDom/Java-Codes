public class ConversionOfIntegers6 {
    public static void main(String[] args) {
        double d = (short) 2.50256e2d;
        char c =  (short)'d';
        short s = (short) 2.22;
        int i = 150000;
        float f =  (short) 0.50f;
        double result = f +  (i / c) - (d * s) - (int) 500e-3;
        System.out.println("result: " + result);
    }
}
