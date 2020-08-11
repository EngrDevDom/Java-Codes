package _1010_Rank_From_Stream;

public class Node {

    int value;
    int leftTreeSize;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        leftTreeSize = 0;
    }
}
