public class WrongPlaseStatics {
    public static int A = 5;
    public static int B = 2 * A;
    public int C = A * B;
    public static int D = A * B;

    public static void main(String[] args) {
        WrongPlaseStatics room = new WrongPlaseStatics();
        room.A = 5;

        WrongPlaseStatics.D = 5;
    }

    public int getA() {

        return A;
    }
}
