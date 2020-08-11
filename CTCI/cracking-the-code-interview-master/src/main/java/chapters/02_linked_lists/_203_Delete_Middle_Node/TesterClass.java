package _203_Delete_Middle_Node;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class TesterClass {

    public static void main(String[] args) {
        test(new Node(new int[]{ 1,2,3,4 }));
        test(new Node(new int[]{ 5,6,7,8,9,10 }));
    }

    private static void test(Node head) {
        System.out.println();
        ListUtilityFunctions.printList(head);

        DeleteMiddleNode.deleteMid(head.next.next);
        ListUtilityFunctions.printList(head);
    }
}
