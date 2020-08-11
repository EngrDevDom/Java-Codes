public class ZeroDivision {
    public static void main(String[] args) {

        try {
            divideByZero();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void divideByZero() {

        System.out.println(5 / 0);
    }
}
