public class NumberWorkExceptions {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }
        //напишите тут ваш код
        catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
