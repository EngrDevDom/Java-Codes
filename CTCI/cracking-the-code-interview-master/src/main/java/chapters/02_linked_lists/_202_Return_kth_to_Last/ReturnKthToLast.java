package _202_Return_kth_to_Last;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class ReturnKthToLast {

    public static Node getKthToLast(Node n, int k) {
        int size = ListUtilityFunctions.getSize(n);
        if (k <= 0 || k > size) {
            return null;
        }
        for (int i = 0; i < size - k; i++) {
            n = n.next;
        }
        return n;
    }

    public static boolean deleteMid(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        n.value = n.next.value;
        n.next = n.next.next;
        return true;
    }
}
