import java.util.Date;

public class Time {
    public static void main(String[] args) {
        Date now = new Date();
        String nowAsString = now.toString();
        long nowInMS = now.getTime();
        long num = 1;

        for (int i = 0; i < 100000; i ++) {
            num *= i;
            num += i;
        }

        Date after = new Date();
        long afterInMS = after.getTime();

        System.out.println(afterInMS - nowInMS);

        System.out.println(now);
        System.out.println(nowAsString);
        System.out.println(afterInMS);
        System.out.println(nowInMS);
    }
}
