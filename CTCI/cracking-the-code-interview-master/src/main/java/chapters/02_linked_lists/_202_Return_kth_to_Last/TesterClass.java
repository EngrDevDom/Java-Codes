package _202_Return_kth_to_Last;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class TesterClass {


    public static void main(String[] args) {
        test(new Node(new int[]{ 5, 6, 4, 9 }), 3);
        test(new Node(new int[]{ 6, 2, 1, 4 }), 2);
    }

    private static void test(Node head, int k) {
        ListUtilityFunctions.printList(head);
        Node m = ReturnKthToLast.getKthToLast(head, k);
        if (m != null) {
            System.out.println("Node " +  k +  "th from end has value " +  m.value);
        } else {
            System.out.println("k = "  +  k + "is outside of range!");
        }
    }
}
