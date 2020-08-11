package _208_Loop_Detection;

import chapters.common.Node;

public class LoopDetection {

    public static Node findLoopStart(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node slowPointer = head;
                while (slowPointer != slow) {
                    slow = slow.next;
                    slowPointer = slowPointer.next;
                }
                return slow;
            }
        }
        return null;
    }
}
