public class Intersection {

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
    }

    public static boolean checkIdenticalValues(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        return node1.val == node2.val && checkIdenticalValues(node1.next, node2.next);

    }

    public static Result getLengthAndTail(Node head){
        if(head == null){
            return null;
        }
        Node node = head;
        int count = 1;
        while(node.next!=null){
            count++;
            node = node.next;
        }
        return new Result(node, count);
    }

    static class Result{
        Node node;
        int length;

        Result(Node node, int count){
            this.node = node;
            this.length = count;
        }
    }

    public static Node intersect(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return null;
        }
        Result result1 = getLengthAndTail(node1);
        Result result2 = getLengthAndTail(node2);

        if(result1.node != result2.node){
            return null;
        }
        Node shorter = result1.length < result2.length ? node1 : node2;
        Node longer = result1.length < result2.length ? node2 : node1;

        longer = getKthNode(longer, Math.abs(result2.length - result1.length));

        while(shorter!=longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;



    }

    public static Node getKthNode(Node node, int size){
        Node n = node;
        while(size>0 && n!=null){
            n = n.next;
            size--;
        }
        return n;
    }

    public static void main(String[] args) {
        LinkedList ls1 = new LinkedList();
        ls1.head = new Node(3);
        ls1.head.next = new Node(5);
        ls1.head.next.next = new Node(9);
        ls1.head.next.next.next = new Node(7);
        ls1.head.next.next.next.next = new Node(2);
        System.out.println("First list: ");
        ls1.print(ls1.head);


        LinkedList ls2 = new LinkedList();
        ls2.head = new Node(4);
        ls2.head.next = new Node(6);
        ls2.head.next.next = ls1.head.next.next.next;
        ls2.head.next.next.next = ls1.head.next.next.next.next;
        System.out.println("Second list: ");
        ls2.print(ls2.head);

        //System.out.println(checkIdenticalValues(ls1.head,ls2.head));
        System.out.println(intersect(ls1.head,ls2.head).val);

    }

}
