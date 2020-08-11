package chapters.common;

public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left = null;
    public BinaryTreeNode right = null;
    public BinaryTreeNode parent = null;
    

    public BinaryTreeNode(int value)
    {
        this.value = value;
    }

    public void addLeftChild(int value) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        left = node;
        node.parent = this;
    }

    public void addRightChild(int value) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        right = node;
        node.parent = this;
    }

    @Override
    public String toString() {

        return String.valueOf(value);
    }
}
