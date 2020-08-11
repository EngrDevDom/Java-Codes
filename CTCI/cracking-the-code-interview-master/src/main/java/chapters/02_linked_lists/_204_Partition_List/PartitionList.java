package _204_Partition_List;

import chapters.common.Node;

public class PartitionList {

    public static Node partitionList(Node head, int val) {
        Node current = head;
        Node pointer = head;
        while (current != null) {
            if (current.value < val) {
                int temp = pointer.value;
                pointer.value = current.value;
                current.value = temp;

                pointer = pointer.next;
            }
            current = current.next;
        }
        return head;
    }
}
