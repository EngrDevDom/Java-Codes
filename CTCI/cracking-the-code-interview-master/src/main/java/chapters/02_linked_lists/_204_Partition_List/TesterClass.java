package _204_Partition_List;

import chapters.common.ListUtilityFunctions;
import chapters.common.Node;

public class TesterClass {

    private static void testPartition(Node head, int partValue) {

        ListUtilityFunctions.printList(head);
        head = PartitionList.partitionList(head, partValue);
        ListUtilityFunctions.printList(head);

    }
    public static void main(String[] args) {
        testPartition(new Node(new int[]{ 1, 2, 5, 7, 6, 8, 10 }), 5);
    }
}
