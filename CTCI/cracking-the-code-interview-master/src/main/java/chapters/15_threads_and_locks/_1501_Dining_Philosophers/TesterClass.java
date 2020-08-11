package _1501_Dining_Philosophers;

public class TesterClass {

    public static void main(String[] args) {

        int numberOfPhilosophers = 5;
        Chopstick[] chopsticks = new Chopstick[numberOfPhilosophers + 1];

        for (int i = 0; i < numberOfPhilosophers + 1; i++) {
            chopsticks[i] = new Chopstick();
        }

        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Chopstick leftChopstick = chopsticks[getLeftChopstickOf(i)];
            Chopstick rightChopstick = chopsticks[getRightChopstickOf(i, numberOfPhilosophers)];
            philosophers[i] = new Philosopher(i, leftChopstick, rightChopstick);
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            philosophers[i].start();
        }

    }

    private static int getLeftChopstickOf(int i) {
        return i;
    }

    private static int getRightChopstickOf(int i, int numberOfPhilosophers) {
        return (i + 1) % numberOfPhilosophers;
    }
}
