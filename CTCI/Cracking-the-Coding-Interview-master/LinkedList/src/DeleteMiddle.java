public class DeleteMiddle {


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

        public void print(Node head){
            while(head != null){
                System.out.print(head.data+" -> ");
                head = head.next;
            }
            System.out.println();
        }

        // will not work if it is the last node of the list
        public boolean deleteNode(Node node){
            if(node.next == null || node == null){
                return false;
            }

            node.data = node.next.data;
            node.next = node.next.next;

            return true;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(2);
        ls.head.next = new Node(3);
        ls.head.next.next = new Node(2);
        //ls.head.next.next.next = new Node(1);
        //ls.head.next.next.next.next = new Node(5);


        ls.print(ls.head);

        System.out.println("After removing node");
        System.out.println(ls.deleteNode(ls.head.next.next));
        ls.print(ls.head);
    }
}
