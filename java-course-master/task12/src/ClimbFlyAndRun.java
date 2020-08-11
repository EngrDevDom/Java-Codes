public class ClimbFlyAndRun {
    public static void main(String[] args) {

    }
    public interface CanFly {

        void fly ();
    }

    public interface CanClimb {
        void climb ();

    }

    public interface CanRun {
        void run ();

    }

    public class Cat implements CanRun, CanClimb {

        @Override
        public void climb() {

        }

        @Override
        public void run() {

        }
        //void fly() {}
        //void run() {}
    }

    public class Dog implements CanRun {
        @Override
        public void run() {

        }
        //void run() {}
    }

    public class Tiger extends Cat {

    }

    public class Duck implements CanFly, CanRun {
        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }
}
