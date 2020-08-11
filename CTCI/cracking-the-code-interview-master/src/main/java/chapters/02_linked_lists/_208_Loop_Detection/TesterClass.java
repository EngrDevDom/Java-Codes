package _208_Loop_Detection;

import chapters.common.Node;

public class TesterClass {

    private static void testLoop(Node head) {
        Node loopStartNode = LoopDetection.findLoopStart(head);
        System.out.println("Loop start node value: " + loopStartNode.value);
    }

    public static void main(String[] args) {
        Node l1 = new Node(10);
        Node l2 = new Node(11);
        Node l3 = new Node(15);
        Node l4 = new Node(16);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2; // loop starting at l2
        testLoop(l1);
    }
}
