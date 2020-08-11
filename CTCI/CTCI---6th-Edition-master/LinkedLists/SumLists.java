package StringRotation.LinkedLists;

public class SumLists {
    static node node1;
    static node node2;

    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            next = null;
        }
    }

    node addTwoLists(node n1, node n2){
        node dummy = new node(0);           // dummy node starts with zero
        int carry = 0; node curr = dummy;
        while(n1!= null || n2!= null){
        int x = (n1 != null)? n1.data:0;
        int y = (n2 != null)? n2.data:0;
        int sum = carry + x+ y;
        carry = sum/10;                    

        curr.next = new node(sum%10);  //putting second digit in the node
        curr = curr.next;
        if(n1!= null)  n1=n1.next;
        if(n2!= null)  n2=n2.next;
        }
        if(carry>0){
            curr.next = new node(carry); //putting last carry in the node if it exists
        }
        return dummy.next;
    }

    void print(node head) {
            while(head.next != null){
                System.out.print(head.data);
                head = head.next;
                System.out.print("-->");
            }
            System.out.print(head.data);
    }

    public static void main(String[] args) {
        SumLists s = new SumLists();
        node1 = new node(7);
        node1.next = new node(1);
        node1.next.next = new node(6);
        System.out.print("The first list is:  ");
        s.print(node1);
        System.out.println();

        node2 = new node(5);
        node2.next = new node(9);
        node2.next.next = new node(2);
        System.out.print("The Second list is: ");
        s.print(node2);

        System.out.println();
        System.out.println("--------------------------------");
        System.out.print("The Sum list is:    ");
        node sum = s.addTwoLists(node1,node2);
        s.print(sum);
                    
                }
}