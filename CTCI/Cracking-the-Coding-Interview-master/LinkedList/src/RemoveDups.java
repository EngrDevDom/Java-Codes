import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class LinkedList{
        Node head;

        public void print(Node head){
            while(head != null){
                System.out.print(head.data+" -> ");
                head = head.next;
            }
            System.out.println();
        }


        public void removeDups(Node head){
            Set<Integer> set = new HashSet<>();

            Node node = head;
            Node prev = null;
            while(node!=null){
                if(set.contains(node.data)){
                    prev.next = node.next;

                }else {
                    set.add(node.data);
                    prev = node;
                }
                node = node.next;
            }

        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.head = new Node(2);
        ls.head.next = new Node(3);
        ls.head.next.next = new Node(2);
        ls.head.next.next.next = new Node(1);

        ls.print(ls.head);

        System.out.println("After removing duplicates :");
        ls.removeDups(ls.head);

        ls.print(ls.head);
    }
}
