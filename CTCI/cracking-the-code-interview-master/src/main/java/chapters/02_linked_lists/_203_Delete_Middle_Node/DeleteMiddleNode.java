package _203_Delete_Middle_Node;

import chapters.common.Node;

public class DeleteMiddleNode {

    public static boolean deleteMid(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        n.value = n.next.value;
        n.next = n.next.next;
        return true;
    }
}
