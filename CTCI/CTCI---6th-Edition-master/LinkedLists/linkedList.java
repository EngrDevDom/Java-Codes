package StringRotation.LinkedLists;


public class linkedList {
    Node head;
    void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null){
            head = node;
        }else{
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }   
    }

    public void insertAt(int data, int index){
        Node node = new Node();
        node.data = data;
        node.next = null;

        Node n = head;
        for(int i=0; i < index-1; i++){
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }

    public void inserAtStart(int data){
        Node node = new Node();
        node.data = data;
        //node.next = null; we dont need it beacuse its automatically defines to null
        node.next = head;
        head = node;
    }

   

    public void show(){
        Node node = head;
        while(node.next != null){
            System.out.print(node.data+" "+"->"+ " ");
            node = node.next;
        }
        /*if(node.next == null){
            System.out.println(node.data);
            this just enlarges time complexity
        }*/
        System.out.print(node.data+"->");

    }
    

}