package _806_Towers_Of_Hanoi;

/**
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
 * of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
 * constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using Stacks.
 */
public class TowersOfHanoi {

    public static void moveDisks(int n, Tower origin, Tower destination, Tower buffer){

        if(n > 0) {
            moveDisks(n-1, origin, buffer, destination);
            moveTop(origin, destination);
            moveDisks(n-1, buffer, destination, origin);
        }

    }

    private static void moveTop(Tower origin, Tower destination){
        Integer disk = origin.pop();
        destination.push(disk);
        System.out.println("Moved disk " + disk + " from Tower " + origin.towerNumber + " to Tower " + destination.towerNumber);
    }

}
