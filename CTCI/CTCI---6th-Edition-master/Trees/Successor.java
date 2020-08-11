

class Node{
    Node left,right,parent;
    int data;
    Node(int data){
        this.data = data;
        left = right = parent = null;
    }
}

public class Successor {
    
    /* Given a binary search tree and a number,  
     inserts a new node with the given number in  
     the correct place in the tree. Returns the new  
     root pointer which the caller should then use*/
    Node insert(Node node, int data){
        if(node == null){
            return (new Node(data));
        }else{
            Node temp = null;

            if(data <= node.data){
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else{
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
            return node;
        }
    }

    Node inOrderSuccessor(Node root,Node n){
        if(n.right != null){
            return minLeftNode(n.right);
        }
        Node p = n.parent;
        while(p!= null && n == p.right){
            n = p;
            p = p.parent;
        }
        return p;
    }

    Node minLeftNode(Node n){
        Node node = n;
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) { 
        Successor tree = new Successor(); 
        Node root = null, temp = null, suc = null; 
        root = tree.insert(root, 20); 
        root = tree.insert(root, 8); 
        root = tree.insert(root, 22); 
        root = tree.insert(root, 4); 
        root = tree.insert(root, 12); 
        root = tree.insert(root, 10); 
        root = tree.insert(root, 14); 
        temp = root.left.right.right; 
        suc = tree.inOrderSuccessor(root, temp); 
        if (suc != null) { 
            System.out.println("Inorder successor of " + temp.data +  
                                                      " is " + suc.data); 
        } else { 
            System.out.println("Inorder successor does not exist"); 
        } 
    } 
}