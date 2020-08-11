public class SortedLinkedListToBST {


    static LNode head;

    static class LNode{
        int data;
        LNode next, prev;

        LNode(int data){
            this.data = data;
            next = prev = null;
        }
    }

    static class TreeNode{
        int data;
        TreeNode left,right;

        TreeNode(int data){
            this.data = data;
            left = right = null;

        }
    }

    public void push(int data){
        LNode node = new LNode(data);
        node.prev = null;
        node.next = head;

        if(head!=null){
            head.prev = node;
        }
        head = node;
    }

    public void printList(LNode node){
        while(node!=null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public int totalNodes(LNode head){
        int count=0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public TreeNode sortedListToBST(){
        int count = totalNodes(head);
        return sortedListToBST(count);
    }

    public TreeNode sortedListToBST(int n){

        if(n<=0){
            return null;
        }

        TreeNode left = sortedListToBST(n/2);
        TreeNode root = new TreeNode(head.data);
        head = head.next;

        root.left = left;

        // n/2 nodes for left subtree, n total nodes existing and 1 for the root, so n-n/2-1 for right subtree
        root.right = sortedListToBST(n-n/2-1);

        return root;

    }

    public static void main(String[] args) {
        SortedLinkedListToBST llist = new SortedLinkedListToBST();

        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);


        System.out.println("Given Linked List ");
        llist.printList(head);

        /* Convert List to BST */
        TreeNode root = llist.sortedListToBST();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);

    }
}
