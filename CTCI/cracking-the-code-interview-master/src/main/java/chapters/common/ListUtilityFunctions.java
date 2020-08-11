package chapters.common;

public class ListUtilityFunctions {



    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        Node n = head;
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static int getSize(Node head) {
        Node n = head;
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }
}
