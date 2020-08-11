public class StackTraceAgain {
    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();



    }

    public static String method2() {
        method3();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();

    }
}
