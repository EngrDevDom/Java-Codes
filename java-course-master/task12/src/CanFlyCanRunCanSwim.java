public class CanFlyCanRunCanSwim {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }

    public class Duck implements CanRun, CanFly, CanSwim {
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Penguin implements CanSwim, CanRun {
        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Toad implements CanSwim {
        @Override
        public void swim() {

        }
    }
}
