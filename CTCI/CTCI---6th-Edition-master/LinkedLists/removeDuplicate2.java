package StringRotation.LinkedLists;

public class removeDuplicate2 {
        
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void removeDuplicate(){
        Node current = head;
        Node runner = null;
        while(current != null){
             runner = current;
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                runner = runner.next;}
            }
            current = current.next;
        }
    }

    void show(){
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data+" "+"->"+" ");
            node = node.next;
        }
        System.out.print(node.data);
    }

    public static void main(String[] args) {
        removeDuplicate2 rd = new removeDuplicate2();
            rd.head = new Node(6);
            rd.head.next = new Node(7);
            rd.head.next.next = new Node(6);
            rd.head.next.next.next = new Node(8);
            rd.head.next.next.next.next = new Node(7);
            rd.head.next.next.next.next.next = new Node(10);

            System.out.println("Linked List BEFORE the remving the duplicates.");
            rd.show();
            System.out.println();
            System.out.println("Linked List AFTER the remving the duplicates.");
            rd.removeDuplicate();
            rd.show();
    }
}