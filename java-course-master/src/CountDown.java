public class CountDown {
    public static void main(String[] args) {

        count1();
        count2();
    }


    public static void count1() {
        for (int i = 10; i > 0; i -= 2)
            System.out.println(" Count " + i);
    }

    public static void count2() {
        for (int i = 9; i > 0; i -= 2)
            System.out.println(" Count " + i);
    }
}
