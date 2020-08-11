public class HorseAndPegasus {
    public static void main(String[] args) {
    }

    public class Horse {
        String name;
        void lopen() {
            System.out.println("I can run");
        }
    }

    public class Pegasus extends Horse {
        String wing;
        void fly() {
            System.out.println("I can fly");
        }
    }
}
