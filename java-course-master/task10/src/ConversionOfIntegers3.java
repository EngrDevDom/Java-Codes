public class ConversionOfIntegers3 {
    public static void main(String[] args) {
        float f = (float) 128.50;
        int i = (int)f;
        int b = (byte) (i + f);
        System.out.println(b);
    }
}
