public class StackTrace2 {
    public static void main(String[] args) {

        int deep = getStackTraceDeep();
        System.out.println(deep);
    }

    public static int getStackTraceDeep() {
        //напишите тут ваш код
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int stackTraceLength = stackTrace.length;
        System.out.println(stackTraceLength);
        return stackTraceLength;
    }
}
