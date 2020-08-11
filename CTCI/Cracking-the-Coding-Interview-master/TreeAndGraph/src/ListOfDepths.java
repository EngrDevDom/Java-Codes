import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    static class Node
    {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree {
        // Root of the Binary Tree
        Node root;

        public BinaryTree() {
            root = null;
        }
    }

    public static void printLevelOrder(Node root){
        if(root == null){
            return;
        }

        printLevelOrder(root.left);
        System.out.println(root.data);
        printLevelOrder(root.right);
    }

    // DFS

    public static void createLinkedListDFS(Node root, ArrayList<LinkedList<Node>> lists, int level){
        if(root == null){
            return;
        }
        LinkedList<Node> list;
        if(lists.size() == level){
            list = new LinkedList<>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);


        createLinkedListDFS(root.left, lists, level+1);
        createLinkedListDFS(root.right, lists, level+1);
    }

    // BFS

    public static void createLinkedListBFS(Node root, ArrayList<LinkedList<Node>> lists){
        LinkedList<Node> current = new LinkedList<>();
        if(root!=null) {
            current.add(root);
        }

        LinkedList<Node> parents;

        while(current.size()>0){

            lists.add(current);
            parents = current;
            current = new LinkedList<>();
            for(Node parent: parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }

        }
    }

    public static void createLinkedList(Node root) {
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();

        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

        System.out.println("DFS traversal:");
        createLinkedListDFS(root, lists, 0);
        print(lists);

        System.out.println("BFS traversal:");
        createLinkedListBFS(root, result);
        print(lists);
    }

    public static void print(ArrayList<LinkedList<Node>> lists){

        for(int i=0;i<lists.size();i++){
            for(int j=0;j<lists.get(i).size();j++){
                System.out.print(lists.get(i).get(j).data+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal: ");
        printLevelOrder(tree.root);
        System.out.println("List of depths: ");
        createLinkedList(tree.root);
    }
}

/*

Algorithm DFS:  Recursive

1. Create an arraylist of linkedLists called lists
2. The recursive function will have the parameters  - root, lists and an additional parameter called level to keep track of the level of the nodes.
3. The index of the arraylist will denote the level of the tree.
4. If the size of the lists is same as level, that means we do not have an entry for that particular level yet in the arraylist.
      So, we create a new linked list called list and add it to the lists.
5. Else we get the list from the lists.
6. Finally add the root to the list.
7. Recursive call for left and right subtrees while incrementing the level by 1.

Algorithm BFS: Iterative

1. Create an arraylist of linkedLists called lists
2. Create a linkedlist called current
3. Add the root to the current
4. Create a linkedlist called parents
5. Iterate till the current linkedlist is not empty
    a) Add current to lists
    b) Reference parents to current
    c) Iterate over the parents linked list
        i) If parent.left is not null - add parent.left to current
        ii) If parent.right is not null - add parent.right to current


 */
