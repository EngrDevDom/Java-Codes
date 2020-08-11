package _201_Remove_Duplicates;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class TesterClass {

    public static void main(String[] args) {
        test(new Node(new int[]{ 3, 7, 7, 4 }));
        test(new Node(new int[]{ 1, 4, 4, 3, 7, 9, 0, 5 }));
    }

    private static void test(Node head) {
        ListUtilityFunctions.printList(head);
        RemoveDuplicates.removeDuplicates(head);
        ListUtilityFunctions.printList(head);
    }
}
