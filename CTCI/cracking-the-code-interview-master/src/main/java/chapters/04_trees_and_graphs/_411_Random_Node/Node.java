package _411_Random_Node;

public class Node {

    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        } else if (other == null || !(other instanceof Node)) {
            return false;
        }
        Node node = (Node) other;
        return this.value == node.value
                && this.left.equals(node.left)
                && this.right.equals(node.right);
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
