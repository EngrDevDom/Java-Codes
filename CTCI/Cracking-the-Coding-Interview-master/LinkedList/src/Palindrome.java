import java.util.Stack;

public class Palindrome {

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
            while (head != null) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.println();
        }

        public boolean isPalindrome(Node head){
            if(head == null){
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            Node node = head;
            while(node!=null){
                stack.push(node.val);
                node = node.next;
            }

            node = head;
            while(node!=null){
                int data = stack.pop();
                if(data != node.val){
                    return false;
                }
                node = node.next;
            }
            return true;
        }

        public boolean isPalindromeOptimised(Node head){
            Stack<Integer> stack = new Stack<>();

            Node slow = head;
            Node fast = head;
            int count =0;

            while(fast!=null && fast.next != null){
                stack.push(slow.val);
                count++;
                slow = slow.next;
                fast = fast.next.next;
            }

            System.out.println("count:" +count);

            // odd number of nodes
            if(fast != null){
                slow = slow.next;
            }

            while(slow!=null) {
                int data = stack.pop();
                if (data != slow.val) {
                    return false;
                }
                slow = slow.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(0);
        ls.head.next = new Node(1);
        ls.head.next.next = new Node(1);
        ls.head.next.next.next = new Node(0);

        ls.print(ls.head);

        System.out.println(ls.isPalindromeOptimised(ls.head));

    }
}
