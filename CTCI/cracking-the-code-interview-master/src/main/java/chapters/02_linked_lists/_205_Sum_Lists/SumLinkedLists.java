package _205_Sum_Lists;

import chapters.common.Node;

public class SumLinkedLists {


    public static Node sumListsInReverseOrder(Node firstNode, Node secondNode) {
        if (firstNode == null) {
            return firstNode;
        } else if (secondNode == null) {
            return secondNode;
        }

        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        int carryValue = 0;

        while (firstNode != null || secondNode != null || carryValue != 0) {
            int value = carryValue;
            if (firstNode != null) {
                value += firstNode.value;
                firstNode = firstNode.next;
            }
            if (secondNode != null) {
                value += secondNode.value;
                secondNode = secondNode.next;
            }
            int digit = value % 10;
            carryValue = value / 10;
            tail.next = new Node(digit);
            tail = tail.next;
        }
        return dummyNode.next;
    }
}
