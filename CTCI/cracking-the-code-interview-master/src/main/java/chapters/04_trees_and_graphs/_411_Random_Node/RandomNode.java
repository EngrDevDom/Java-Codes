package _411_Random_Node;

/**
 * You are implementing a binary search tree class from scratch, which, in addition
 * to insert , find , and delete , has a method getRandomNode() which returns a random node
 * from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 * for getRandomNode.
 */
public class RandomNode {

    Node root = null;
    RandomCollection<Node> randomCollection = new RandomCollection<>();

    public void insert(int value) {

        Node node = new Node(value);

        randomCollection.add(node);

        if (root == null) {
            root = node;
            return;
        }
        Node currentNode = root;
        while (true) {
            if (value <= currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = node;
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = node;
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public Node find(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (value == currentNode.value) {
                return currentNode;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    public Node getRandomNode()
    {
        return randomCollection.getRandom();
    }

}
