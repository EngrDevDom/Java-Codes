package _1010_Rank_From_Stream;

/**
 * Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish
 * to be able to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations. That is, implement
 * the method track(in t x), which is called when each number is generated, and the method
 * getRankOfNumber(int x), which returns the number of values (ess than or equal to x (not
 * including x itself).
 * EXAMPLE
 * Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7 , 13, 3
 * getRankOfNumber(l) = 0
 * getRank0fNumber(3) = 1
 * getRank0fNumber(4) = 3
 */
public class RankFromStream {

    private static Node root = null;

    public static void track(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            insert(root, x);
        }
    }

    private static void insert(Node node, int x) {

        Node current = node;
        while (true) {
            if (x <= current.value) {
                current.leftTreeSize++;
                if (current.left == null) {
                    current.left = new Node(x);
                    return;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(x);
                    return;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public static int getRankOfNumber(int x) {
        if (root == null) {
            return 0;
        }
        Node current = root;
        int rank = 0;
        while (current != null) {
            if (x == current.value) {
                return rank + current.leftTreeSize;
            } else if (x > current.value) {
                rank += 1 + current.leftTreeSize;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return 0;
    }

    public static void trackNodes(int[] array) {
        for (int i : array) {
            track(i);
        }
    }

}
