package _806_Towers_Of_Hanoi;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tower {

    private Deque<Integer> disks;
    public int towerNumber;

    public Tower(int towerNumber) {
        this.disks = new ArrayDeque<>();
        this.towerNumber = towerNumber;
    }

    public void push(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error pacing disk: " + d + " on tower " + towerNumber);
        } else {
            disks.push(d);
        }
    }

    public Integer pop() {
        if (disks.isEmpty()) {
            return null;
        } else {
            return disks.pop();
        }
    }
}
