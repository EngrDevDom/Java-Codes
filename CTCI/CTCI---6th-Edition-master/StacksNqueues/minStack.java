<<<<<<< HEAD
package StringRotation.StacksNqueues;

import java.util.Stack;

public class minStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        public void push(int x){
                if(x <= min){
                    stack.push(min); //pushing the second min value to stack
                    min = x;
                }
                stack.push(x);
        }

        public void pop(){
            if(stack.pop() == min){
                min = stack.pop();  //here helps that second min value
            }
        }

        public int peek(){
            return stack.peek();
        }
        public int getMin() {
            return min;
        }

        public static void main(String[] args) 
    { 
        minStack s = new minStack(); 
        s.push(3); 
        s.push(5); 
        System.out.println(s.getMin()); 
        s.push(2); 
        s.push(1); 
        System.out.println(s.getMin());  
        s.pop(); 
        System.out.println(s.getMin());  
        s.pop(); 
        System.out.println(s.peek());  
    }
}
/* OUTPUT:
        3
        1
        2
=======


import java.util.Stack;

public class minStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        public void push(int x){
                if(x <= min){
                    stack.push(min); //pushing the second min value to stack
                    min = x;
                }
                stack.push(x);
        }

        public void pop(){
            if(stack.pop() == min){
                min = stack.pop();  //here helps that second min value
            }
        }

        public int peek(){
            return stack.peek();
        }
        public int getMin() {
            return min;
        }

        public static void main(String[] args) 
    { 
        minStack s = new minStack(); 
        s.push(3); 
        s.push(5); 
        System.out.println(s.getMin()); 
        s.push(2); 
        s.push(1); 
        System.out.println(s.getMin());  
        s.pop(); 
        System.out.println(s.getMin());  
        s.pop(); 
        System.out.println(s.peek());  
    }
}
/* OUTPUT:
        3
        1
        2
>>>>>>> c43b86aef218106244aae96b3881472fffcc82fa
        5  */