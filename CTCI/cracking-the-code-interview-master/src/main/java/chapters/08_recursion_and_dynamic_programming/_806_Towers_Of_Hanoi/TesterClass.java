package _806_Towers_Of_Hanoi;

public class TesterClass {

    public static void main(String[] args) {


        int numberOfTowers = 3;
        int numberOfDisks = 7;
        Tower[] towers = new Tower[numberOfTowers];
        for (int i = 0; i < numberOfTowers; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = numberOfDisks; i > 0; i--) {
            towers[0].push(i);
        }
        TowersOfHanoi.moveDisks(numberOfDisks, towers[0], towers[2], towers[1]);
    }
}
