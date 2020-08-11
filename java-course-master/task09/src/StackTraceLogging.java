public class StackTraceLogging {
    public static void main(String[] args) {

        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        String a = Thread.currentThread().getStackTrace()[2].getClassName();
        String b = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(a + ": " + b + ": " + s);
    }
}
