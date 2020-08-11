package _207_List_Intersection;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class TesterClass {


    public static void main(String[] args) {

        Node l1 = new Node(new int[]{ 2, 4, 6, 3 });
        Node l2 = new Node(new int[]{ 1, 3 });
        Node rest  = new Node(new int[]{ 17, 18, 5 });
        l1.appendToTailNode(rest);
        l2.appendToTailNode(rest);
        test(l1, l2);
    }

    private static void test(Node l1, Node l2) {
        ListUtilityFunctions.printList(l1);
        ListUtilityFunctions.printList(l2);
        System.out.println("Intersection node is: " + ListIntersection.findListIntersectionNode(l1, l2));
    }
}
