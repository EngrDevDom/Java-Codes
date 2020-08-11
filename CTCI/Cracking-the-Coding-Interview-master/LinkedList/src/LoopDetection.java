import java.util.HashSet;
import java.util.Set;

public class LoopDetection {

    static class Node{
        int val;
        Node next;

        Node(int data){
            this.val = data;
            next = null;
        }

    }

    static class LinkedList{
        Node head;

        public void print(Node head) {
            int count = 20;
            while (head != null && count > 0) {
                System.out.print(head.val + " -> ");
                head = head.next;
                count --;
            }
            System.out.print("Null");

        }

        public int getLength(Node head){
            Node node = head;
            Set<Node> set = new HashSet<>();

            while(node!=null){
                if(set.contains(node)){
                    //System.out.println(node.val);
                    break;
                }
                set.add(node);
                node = node.next;
            }
            return set.size();
        }

        public void loopDetect(Node head){
            Node slow = head;
            Node fast = head;

            while(true){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    System.out.println("Loop Detected");
                    break;
                }
            }
        }

        // count = length - number of nodes outside of loop
        public Node  detection(Node head){
            Node slow = head;
            Node fast = head;
            Set<Node> set = new HashSet<>();
            int count = 0;
            int length = getLength(head);

            while(true){
                set.add(slow);
                slow = slow.next;
                fast = fast.next.next;
                count++;
                if(slow == fast){
                    break;
                }
            }
            Node node = head;
            int k = length - count;
            while(k>0){
                head = head.next;
                k--;
            }
            return head;

        }

        // CTCI approach
        public Node detectionOptimised(Node head){
            Node slow = head;
            Node fast = head;

            while(fast!= null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    break;
                }
            }

            if(fast == null || fast.next == null){
                return null;
            }
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(2);
        ls.head.next = new Node(4);
        ls.head.next.next = new Node(6);
        ls.head.next.next.next = new Node(8);
        ls.head.next.next.next.next = new Node(10);
        ls.head.next.next.next.next.next = ls.head.next.next;

        //ls.print(ls.head);

        //System.out.println(ls.detection(ls.head).val);
        System.out.println(ls.detectionOptimised(ls.head));


    }

}
