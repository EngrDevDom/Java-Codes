package StringRotation.LinkedLists;

public class kthelement {

     Node head;
    static class Node{
         int data;
         Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void knodes(int n){
        Node current = head;
        Node runner = null;
        int count = 0;
        while(current != null){
            
            if(count == n){
                runner = current;
                while(runner.next != null){
                    System.out.print(runner.data+"->");
                    runner = runner.next;
                }
                System.out.println(runner.data);
            }
            count++;
            current = current.next;
        }
    }

    void show(){
        Node node = head;
        System.out.println();
        while (node.next != null) {
            
            System.out.print(node.data+" "+"->"+" ");
            node = node.next;
        }
        System.out.print(node.data);
    }

    public static void main(String[] args) {
        kthelement k = new kthelement();
            k.head = new Node(6);
            k.head.next = new Node(7);
            k.head.next.next = new Node(6);
            k.head.next.next.next = new Node(8);
            k.head.next.next.next.next = new Node(7);
            k.head.next.next.next.next.next = new Node(10);

            System.out.println("Linked List");
            k.show();
            System.out.println();
            System.out.println("Linked List AFTER the 2nd element");
            k.knodes(2);
            
    }

}