package StringRotation.LinkedLists;

import java.util.Stack;

public class palindrome {
        static node head;
        static class node{
            int data;
            node next;
            node(int data){
                this.data = data;
        }
    }

        boolean isPalin(node n){
<<<<<<< HEAD
=======
             if(n == null){
                     return true;
             }
>>>>>>> c43b86aef218106244aae96b3881472fffcc82fa
            Stack<Integer> stack = new Stack<Integer>();
            int count=0;
            node dummy = n;
            node curr = n;
            while(n.next != null){
                count++;
                n = n.next;
            }
            count++;

            int middle = count/2;

            //node dummy = new node(0);
            int count2 = 0;
            boolean flag =false;
            
            while(dummy.next != null){
                    count2++;
                    if(count2 > middle){
                        dummy = dummy.next;
                        stack.push(dummy.data);
                    }
                    dummy=dummy.next;
            }stack.push(dummy.data);

            System.out.println(stack);

            for(int i=0; i<middle;i++){
                Integer a = stack.pop();
                System.out.println(a);
                System.out.println(curr.data);
                 if(a == curr.data){
                    flag = true;
                }
                if(a != curr.data){
                    flag = false;
                }
                curr = curr.next;
            }
                return flag;
            }
        public static void main(String[] args) {
            palindrome p = new palindrome();
            head = new node(1);
            head.next = new node(2);
            head.next.next = new node(3);
            head.next.next.next = new node(3);  // part 1 node(2)
            head.next.next.next.next = new node(1);

            boolean b = p.isPalin(head);
            System.out.println(b);

        }
}

/* OUTPUT:
part 1 :
[2, 1] ,<- stack items
1
1
2
2
true       part 2:
            [3, 1]
            1
            1
            3
            2
            false     */
