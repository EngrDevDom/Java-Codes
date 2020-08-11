public class FlyRunSwim {
    public static void main(String[] args) {

    }

    //add interfaces here - добавь интерфейсы тут
    public interface CanFly {
        void fly (String newDestination);
    }

    public interface CanRun {
        void move (String newAddress);
    }

    public interface CanSwim {
        void swim (String whereIsSea);

    }
}
