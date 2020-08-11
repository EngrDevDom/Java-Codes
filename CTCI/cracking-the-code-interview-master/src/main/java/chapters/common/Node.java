package chapters.common;

public class Node {

    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    /**
     * Create single linked list from int array
     * @param array
     */
   public Node (int[] array){
        value = array[0];
        Node current = this;
        for(int i = 1; i < array.length; i++){
            current.next = new Node(array[i]);
            current = current.next;
        }
   }

    /**
     * Create node from value and append it to tail
     * @param value
     */
    public void appendToTailNode(int value) {
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    /**
     * Append existing node to tail
     * @param node
     */
    public void appendToTailNode(Node node) {
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }



}
