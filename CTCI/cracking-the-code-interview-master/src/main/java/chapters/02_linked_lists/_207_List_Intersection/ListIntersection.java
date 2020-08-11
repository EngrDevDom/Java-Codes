package _207_List_Intersection;

import chapters.common.Node;

public class ListIntersection {

    public static Integer findListIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }
        return temp1 == null ? null: temp1.value;
    }
}
