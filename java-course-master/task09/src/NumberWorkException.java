public class NumberWorkException {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            int a = 42 / 0;
        }

        //напишите тут ваш код
        catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
