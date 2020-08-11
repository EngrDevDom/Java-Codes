package _411_Random_Node;

public class TesterClass {

    public static void main(String[] args) {

        RandomNode binaryTree = new RandomNode();
        int[] intArray = {3, 1, 5, 0, 2, 4, 7, 6, 9};
        for (int i : intArray) {
            binaryTree.insert(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(binaryTree.getRandomNode() + " ");
        }
    }
}
