package _201_Remove_Duplicates;

import chapters.common.Node;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void removeDuplicates(Node head) {
        Set<Integer> set = new HashSet<>();
        set.add(head.value);
        Node current = head;
        while (current.next != null) {
            if (set.contains(current.next.value)) {
                current.next = current.next.next;
            } else {
                set.add(current.next.value);
                current = current.next;
            }
        }
        return;
    }

}
