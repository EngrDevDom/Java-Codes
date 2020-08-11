public class RunnerTechnique {

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
            System.out.print("NULL");
            System.out.println();
        }

        public void runner(Node head){
            Node slow = head;
            Node fast = head;
            int count = 0;

            while(fast!=null && fast.next != null){
                System.out.println(slow.val);
                slow = slow.next;
                fast = fast.next.next;
                count++;
            }
            System.out.println("slow data: "+slow.val);
            System.out.println("count: "+count);

            if(fast == null){
                System.out.println("Total is even number of nodes: "+(count+count));
            }else{
                System.out.println("Total is odd number of nodes: " + (count+count+1) );
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(0);
        ls.head.next = new Node(1);
        ls.head.next.next = new Node(0);
        ls.head.next.next.next = new Node(5);
        ls.head.next.next.next.next = new Node(8);

        ls.print(ls.head);

        ls.runner(ls.head);

    }

}
