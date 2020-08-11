public class AllThatMoves {
    public static void main(String[] args) throws Exception {
    }
    interface CanMove {
        Double speed();
    }
    interface CanFly extends CanMove {
        Double speed(CanFly fly);
    }
}
