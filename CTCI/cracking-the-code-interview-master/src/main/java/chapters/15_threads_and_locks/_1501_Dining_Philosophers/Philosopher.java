package _1501_Dining_Philosophers;

/**
 * Dining Philosophers; In the famous dining philosophers problem, a bunch of philosophers are
 * sitting around a circular table with one chopstick between each of them. A philosopher needs both
 * chopsticks to eat, and always picks up the left chopstick before the right one. A deadlock could
 * potentially occur if all the philosophers reached for the left chopstick at the same time. Using threads
 * and locks, implement a simulation of the dining philosophers problem that prevents deadlocks.
 */
public class Philosopher extends Thread {

    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;


    private int bites = 5;
    private int maxPause = 200;

    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public void eat() {
        System.out.println("Philosopher " + id + " starts eating");
        if (pickUpChopsticks()) {
            chew();
            putDown();
            System.out.println("Philosopher " + id + " is done eating");
        } else {
            System.out.println("Philosopher " + id + " gave up on eating");
        }
    }

    public void chew() {
        System.out.println("Philosopher " + id + " is eating!");
    }

    public boolean pickUpChopsticks() {
        pause();
        if (!leftChopstick.pickUpChopstick()) {
            return false;
        }
        pause();
        if (!rightChopstick.pickUpChopstick()) {
            leftChopstick.putDownChopstick();
            return false;
        }
        pause();
        return true;
    }

    public void putDown() {
        leftChopstick.putDownChopstick();
        rightChopstick.putDownChopstick();
    }

    public void pause() {
        try {
            int pause = randomIntInRange(0, maxPause);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }


}
