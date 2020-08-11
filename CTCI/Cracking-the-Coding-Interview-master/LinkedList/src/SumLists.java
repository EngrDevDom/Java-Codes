public class SumLists {

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
    }

    public static int convertToNum(Node node){
        int num = 0;
        int n = 0;

        while(node!=null){
            num += (int)Math.pow(10,n) * node.data;
            n++;
            node = node.next;
        }
        return num;
    }

    public static void convertToList(int sum){
        Node list = null;
        Node head = null;
        while(sum != 0){
            int num = sum%10;
            sum /= 10;
            if(list == null){
                list = new Node(num);
                head = list;
            }else{
                list.next = new Node(num);
                list = list.next;
            }
        }
        System.out.println("Printing: ");
        while(head != null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
    }

    public static void bruteForce(Node A, Node B){
        int a = convertToNum(A);
        int b = convertToNum(B);
        int sum = a+b;

        convertToList(sum);
    }

    public static void main(String[] args) {
        // 1st list -  number is 617
        LinkedList ls1 = new LinkedList();
        ls1.head = new Node(7);
        ls1.head.next = new Node(1);
        ls1.head.next.next = new Node(6);

        // 2nd list -  number is 295
        LinkedList ls2 = new LinkedList();
        ls2.head = new Node(5);
        ls2.head.next = new Node(9);
        ls2.head.next.next = new Node(2);

        System.out.println("First List:");
        ls1.print(ls1.head);

        System.out.println("Second List:");
        ls2.print(ls2.head);

        System.out.println("Brute Force approach:");
        bruteForce(ls1.head, ls2.head);
    }
}
