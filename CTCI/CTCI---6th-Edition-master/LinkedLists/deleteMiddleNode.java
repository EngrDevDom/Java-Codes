/* This solution is one of many examples of my hyperactivity, never read that i have access to the node 
which is going to be deleted, not the head node*/
/*boolean(Node n){
    if(n == null || n.next == null){ return false; }
    Node next = n.next;
    n.data = next.data;
    n.next = next.next;
    return true;     
*/
package StringRotation.LinkedLists;
public class deleteMiddleNode {
    Node head;
    static class Node{
         int data;
         Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    void deleteMiddle(int n){
        Node current = head;
        int count = 0;
        while(current.next != null){
            
            if(count == n){
               current = current.next;
            }
            System.out.print(current.data+"-->");
            count++;
            current = current.next;
        }
        System.out.println(current.data);
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
        deleteMiddleNode k = new deleteMiddleNode();
            k.head = new Node(6);
            k.head.next = new Node(7);
            k.head.next.next = new Node(6);
            k.head.next.next.next = new Node(8);
            k.head.next.next.next.next = new Node(7);
            k.head.next.next.next.next.next = new Node(10);

            System.out.println("Linked List");
            k.show();
            System.out.println();
            System.out.println("Linked List AFTER deleting the 2nd element");
            k.deleteMiddle(3);            
    }
}
