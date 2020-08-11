public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 5; i ++)
            builder.append(s);
        result = builder.toString();
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder();

        for ( int i = 0; i < count; i ++)
            builder.append(s);
        result = builder.toString();
        return result;
    }

    public static void main(String[] args) {
     /*   String a, b;
        a = StringHelper.multiply("Amigo");
        b = StringHelper.multiply("Amigo", 3);
        System.out.println(a);
        System.out.println(b); */
    }
}
