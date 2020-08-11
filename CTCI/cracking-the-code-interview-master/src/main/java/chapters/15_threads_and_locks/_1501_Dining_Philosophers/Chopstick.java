package _1501_Dining_Philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private Lock lock;

    public Chopstick() {
        this.lock = new ReentrantLock();
    }

    public boolean pickUpChopstick(){
        return lock.tryLock();
    }

    public void putDownChopstick(){
        lock.unlock();
    }

}
