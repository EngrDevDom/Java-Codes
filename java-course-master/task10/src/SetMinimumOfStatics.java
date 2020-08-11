public class SetMinimumOfStatics {
    public int A = 5;
    public static int B = 5;
    public static int C = 5;
    public static int D = 5;

    public static void main(String[] args) {
        SetMinimumOfStatics solution = new SetMinimumOfStatics();
        solution.A = 5;
        solution.B = 5 * B;
        solution.C = 5 * C * D;
        SetMinimumOfStatics.D = 5 * D * C;

        SetMinimumOfStatics.D = 5;
    }

    public int getA() {

        return A;
    }
}
