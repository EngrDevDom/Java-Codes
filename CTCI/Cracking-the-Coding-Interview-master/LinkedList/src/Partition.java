public class Partition {


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

        public Node partition(Node head, int x){
            Node node = head;
            Node head1=null, head2=null, tail1=null, tail2=null;

            while(node!=null){
                if(node.data < x){
                    if(head1 == null){
                        head1 = node;
                        tail1 = node;
                    }else{
                        tail1.next = node;
                        tail1 = tail1.next;
                    }
                }else{
                    if(head2 == null){
                        head2 = node;
                        tail2 = node;
                    }else{
                        tail2.next = node;
                        tail2 = tail2.next;
                    }
                }
                node = node.next;
            }
            tail2.next = null;
            tail1.next = head2;
            return head1;

        }

        public Node partition2nd(Node node, int x){
            Node head = node;
            Node tail = node;

            while(node!=null){
                Node next = node.next;
                if(node.data < x){
                    node.next = head;
                    head = node;
                }else{
                    tail.next = node;
                    tail = node;
                }
                node = next;
            }
            tail.next = null;
            return head;
        }

        public Node partition3rd(Node head, int x){
            Node p1 = null;
            Node p2 = null;
            Node dummy = null;
            Node n = null;

            Node node = head;

            while(node!=null){

                Node ptr = new Node(node.data);
                if(ptr.data < x){
                    //less
                    if(p1 == null){
                        p1 = ptr;
                        n = p1;
                    }else{
                        p1.next = ptr;
                        p1 = p1.next;
                    }
                }else{
                    //more
                    if(p2 == null){

                        p2 = ptr;
                        dummy = p2;
                    }else{
                        p2.next = ptr;
                        p2 = p2.next;
                    }
                }

                node = node.next;
            }
            p1.next = dummy;
            return n;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(3);
        ls.head.next = new Node(5);
        ls.head.next.next = new Node(8);
        ls.head.next.next.next = new Node(1);
        ls.head.next.next.next.next = new Node(10);
        ls.head.next.next.next.next.next = new Node(2);
        ls.head.next.next.next.next.next.next = new Node(1);

        ls.print(ls.head);
        int x = 5;

        //System.out.println("After partitioning:");
        //ls.head = ls.partition(ls.head, x);
        //ls.print(ls.head);

        System.out.println("2nd approach");
        ls.head = ls.partition2nd(ls.head,x);
        ls.print(ls.head);

        // similar to 2nd approach
        //System.out.println("3rd approach");
        //ls.head = ls.partition3rd(ls.head,x);
        //ls.print(ls.head);

    }
}
