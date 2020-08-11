package StringRotation.LinkedLists;

import java.util.HashSet;

public class removeDuplicates {
        //Mr. Head of the Linked List
         node head;

        //Nodes are created here
        static class node{
                int data;
                node next;
                node(int data){
                    this.data = data;
                    this.next = null;
                }
        }

        //Printing MAchine
        void show(){
            node node = head;
            while(node.next != null){
                System.out.print(node.data+" "+"->"+" ");
                node = node.next;
            }
            System.out.print(node.data);
        }

        //Remove Duplicates
        public void removeDuplicate(){
            node n = head;
            HashSet<Integer> set = new HashSet<Integer>();
            node prev = n;
            while(n != null){
                if(set.contains(n.data)){
                    prev.next = n.next;

                }else{
                set.add(n.data);
                prev = n;
                }
                n = n.next;
            }
          
        }

        public static void main(String[] args) {
            removeDuplicates rd = new removeDuplicates();
            rd.head = new node(6);
            rd.head.next = new node(7);
            rd.head.next.next = new node(6);
            rd.head.next.next.next = new node(8);
            rd.head.next.next.next.next = new node(7);
            rd.head.next.next.next.next.next = new node(10);

            System.out.println("Linked List BEFORE the remving the duplicates.");
            rd.show();
            System.out.println();
            System.out.println("Linked List AFTER the remving the duplicates.");
            rd.removeDuplicate();
            rd.show();
        }

}