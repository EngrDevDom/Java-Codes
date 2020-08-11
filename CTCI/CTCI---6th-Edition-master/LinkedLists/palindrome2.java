package StringRotation.LinkedLists;

public class palindrome2 {
    static node head;
    static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
    }
}

    boolean isPalin(node n){
        node reversed = reversenclone(n);
        return isEqual(n,reversed);
    }

    node reversenclone(node n){
        node head = null;
        while(n != null){
            node node = new node(n.data);
<<<<<<< HEAD
            node.next = head; //appending head to last of node.data
            head = node; //backing the pointer head to first node
=======
            node.next = head; //appending to last
            head = node; //backing the pointer to first node
>>>>>>> c43b86aef218106244aae96b3881472fffcc82fa
            n = n.next;
        }
        return head;
    }

    boolean isEqual(node n1, node n2){
        while (n1 != null && n2 != null){
            if(n1.data != n2.data){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1==null && n2 ==null;
    }

    

public static void main(String[] args) {
    palindrome2 p = new palindrome2();
    head = new node(1);
    head.next = new node(2);
    head.next.next = new node(3);
<<<<<<< HEAD
    head.next.next.next = new node(2);  
=======
    head.next.next.next = new node(2);  // part 1 node(2)
>>>>>>> c43b86aef218106244aae96b3881472fffcc82fa
    head.next.next.next.next = new node(1);

    boolean b = p.isPalin(head);
    System.out.println(b);

}



}