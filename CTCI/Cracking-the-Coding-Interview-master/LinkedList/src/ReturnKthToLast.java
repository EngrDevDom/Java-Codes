public class ReturnKthToLast {


    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
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

        public int getSize(Node head){
            int size = 0;
            Node current = head;
            while(current!=null){
                current = current.next;
                size++;
            }
            return size;
        }

        public void removeKth(Node head, int k){
            int size = getSize(head);
            int n = size - k;
            int count = 0;

            Node current = head;
            while(n>0){
                current = current.next;
                n--;
            }
            System.out.println(current.data);
        }

        public int removeKthRecursive(Node head, int k){
            if(head == null){
                return 0;
            }
            int index = removeKthRecursive(head.next, k)+1;
            if(index == k){
                System.out.println("Value is: "+ head.data);
            }
            return index;
        }

        public Node removeKthIteratively(Node head, int k){
            Node p1 = head;
            Node p2 = head;

            int count = k;

            while(count > 0){
                if(p1 == null){
                    return null;
                }
                p1 = p1.next;
                count --;
            }
            while(p1 != null){
                p1=p1.next;
                p2=p2.next;
            }
            return p2;

        }

        public Node removeNthFromEnd(Node head, int k){
            Node dummy = new Node(0);
            dummy.next = head;
            Node p1 = head;
            Node p2 = head;

            for(int i=1;i<=k+1;i++){
                if(p1 == null){
                    return null;
                }
                p1 = p1.next;
            }

            while(p1 != null){
                p1=p1.next;
                p2=p2.next;

            }
            p2.next = p2.next.next;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(2);
        ls.head.next = new Node(8);
        ls.head.next.next = new Node(3);
        ls.head.next.next.next = new Node(5);
        ls.head.next.next.next.next = new Node(7);

        ls.print(ls.head);
        int k = 1;

        System.out.println("After removing kth element :");
        ls.removeKth(ls.head, k);
        ls.removeKthRecursive(ls.head, k);
        Node node = ls.removeKthIteratively(ls.head,k);
        System.out.println("Value kth: "+node.data);

        Node head = ls.removeNthFromEnd(ls.head,k);

        ls.print(ls.head);
    }
}
