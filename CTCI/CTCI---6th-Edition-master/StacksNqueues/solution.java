<<<<<<< HEAD
package StringRotation.StacksNqueues;
    class solution{
    static class MyQueue {
        int data;
        MyQueue next;
        /** Initialize your data structure here. */
        public MyQueue(int data) {
            this.data =  data;
            this.next = null;
        }
    }
        MyQueue stack1;
        MyQueue stack2;
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1 = new MyQueue(x);
            stack1 = stack1.next;        
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int item;
            while(stack1 != null){
                System.out.println("stack1  "+stack1.data);
                stack1 = stack1.next;
            }
            MyQueue dummy = new MyQueue(0);
            if(stack2 == null){
                while(stack1 != null){
                    stack2 = stack1;
                    stack1 = stack1.next;
                    dummy.next = stack2;
                    System.out.println(dummy.next.data+"<- dummy node ");
                }
                item = dummy.next.data;
                dummy.next = dummy.next.next;
                }
            dummy.next = stack2;
            item = dummy.next.data;
            dummy.next = dummy.next.next;
            return stack2.data;
            }
    
        
        /** Get the front element. */
        public int peek() {
            MyQueue dummy = new MyQueue(0);
            if(stack2 == null){
                while(stack1 != null){
                    stack2 = stack1;
                    stack1 = stack1.next;
                    dummy.next = stack2;
                }}
            dummy.next = stack2;
            return stack2.data;
        }
        
        /** Returns whether the queue is empty. */
         public boolean empty() {
            return stack1 == null && stack2 == null;
        }

        public static void main(String[] args) {
            solution obj = new solution();
            obj.push(1);
            obj.push(2);
            obj.push(3);
            int param_2 = obj.pop();
            System.out.println(param_2);
            int param_3 = obj.peek();
            System.out.println(param_3);
            boolean param_4 = obj.empty();
            System.out.println(param_4);
        }

}
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
=======

    class solution{
    static class MyQueue {
        int data;
        MyQueue next;
        /** Initialize your data structure here. */
        public MyQueue(int data) {
            this.data =  data;
            this.next = null;
        }
    }
        MyQueue stack1;
        MyQueue stack2;
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1 = new MyQueue(x);
            stack1 = stack1.next;        
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while(stack1 != null){
                System.out.println("stack1  "+stack1.data);
                stack1 = stack1.next;
            }
            int item;
            MyQueue dummy = new MyQueue(0);
            if(stack2 == null){
                while(stack1 != null){
                    stack2 = stack1;
                    stack1 = stack1.next;
                    dummy.next = stack2;
                    System.out.println(dummy.next.data+"<- dummy node ");
                }
                 item = dummy.next.data;
                dummy.next = dummy.next.next;
                }
            dummy.next = stack2;
            item = dummy.next.data;
            dummy.next = dummy.next.next;
            return stack2.data;
            }
    
        
        /** Get the front element. */
        public int peek() {
            MyQueue dummy = new MyQueue(0);
            if(stack2 == null){
                while(stack1 != null){
                    stack2 = stack1;
                    stack1 = stack1.next;
                    dummy.next = stack2;
                }}
            dummy.next = stack2;
            return stack2.data;
        }
        
        /** Returns whether the queue is empty. */
         public boolean empty() {
            return stack1 == null && stack2 == null;
        }

        public static void main(String[] args) {
            solution obj = new solution();
            obj.push(1);
            obj.push(2);
            obj.push(3);
            int param_2 = obj.pop();
            System.out.println(param_2);
            int param_3 = obj.peek();
            System.out.println(param_3);
            boolean param_4 = obj.empty();
            System.out.println(param_4);
        }

}
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
>>>>>>> c43b86aef218106244aae96b3881472fffcc82fa
