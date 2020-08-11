package _301_Three_Stacks_In_One;

public class TesterClass {

    public static void main(String[] args) {
        ThreeStacksInOne stacks = new ThreeStacksInOne();
        try {
            stacks.push(1, 0);
            stacks.push(2, 0);
            stacks.push(3, 0);
            stacks.push(4, 1);
            stacks.push(5, 1);
            stacks.push(6, 1);
            stacks.push(7, 2);
            stacks.push(8, 2);
            stacks.push(9, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stacks.printStacks();
    }
}
