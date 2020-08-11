package _205_Sum_Lists;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class TesterClass {


    private static void testSumInReverseOrder(Node l1Head, Node l2Head) {
        ListUtilityFunctions.printList(l1Head);
        ListUtilityFunctions.printList(l2Head);
        Node sum = SumLinkedLists.sumListsInReverseOrder(l1Head, l2Head);
        ListUtilityFunctions.printList(sum);
    }

    public static void main(String[] args) {
        testSumInReverseOrder(new Node(new int[]{ 16, 2, 5, 7, 9 }), new Node(new int[]{ 1, 7, 9, 5, 10 }));
    }


}
