public class SumListsOptimised {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
        Node(){
            next = null;
        }
    }

    static class LinkedList {
        Node head;

        public void print(Node head) {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void sum(Node A, Node B){
        Node result = null;
        Node head = null;
        int carry = 0;
        while(A !=null && B!= null){
            int sum = A.data + B.data;

            Node n = new Node(sum%10 + carry);
            carry = sum/10;
            if(result == null){
                result = n;
                head = result;
            }else{
                result.next = n;
                result = result.next;
            }


            A = A.next;
            B = B.next;
        }
        if(A!= null){
            Node n = new Node(A.data + carry);
            result.next = n;
            A = A.next;
            result = result.next;
        }
        if(B!= null){
            Node n = new Node(B.data + carry);
            result.next = n;
            B = B.next;
            result = result.next;
        }

        System.out.println("Final result: ");

        while(head !=null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
    }

    public static Node sumHelper(Node l1,Node l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        int value = carry;
        Node result = new Node();
        if(l1 != null){
            value += l1.data;
        }

        if(l2 != null){
            value += l2.data;
        }

        result.data = value%10;

        if(l1 != null || l2 != null){
            Node more = sumHelper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value/10);
            result.next = more;
        }

        return result;
    }

    public static void sumRecursive(Node l1, Node l2){
        Node head = sumHelper(l1,l2,0);

        while(head != null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // 1st list -  number is 617
        LinkedList ls1 = new LinkedList();
        ls1.head = new Node(1);
        ls1.head.next = new Node(2);
        ls1.head.next.next = new Node(3);

        // 2nd list -  number is 295
        LinkedList ls2 = new LinkedList();
        ls2.head = new Node(9);
        ls2.head.next = new Node(2);
        ls2.head.next.next = new Node(9);
        ls2.head.next.next.next = new Node(1);

        System.out.println("First List:");
        ls1.print(ls1.head);

        System.out.println("Second List:");
        ls2.print(ls2.head);

        //sum(ls1.head, ls2.head);

        System.out.println("Recursive version");
        sumRecursive(ls1.head, ls2.head);
    }


}
