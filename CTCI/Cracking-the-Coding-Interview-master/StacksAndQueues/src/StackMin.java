import java.util.Stack;

public class StackMin {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();

    public void push(int x){
        stack.push(x);
        if(min_stack.isEmpty() || min_stack.peek() > x){
            min_stack.push(x);
        }
    }

    public void pop(){
        int item = stack.pop();
        if(min_stack.peek() == item){
            min_stack.pop();
        }
    }

    public int getMin(){
        if(min_stack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return min_stack.peek();
    }

    public static void main(String[] args){
        StackMin sm = new StackMin();
        System.out.println(sm.getMin()); // Integer max value as stack is empty
        sm.push(3);
        sm.push(4);
        System.out.println(sm.getMin());
        sm.pop();
        sm.push(2);
        System.out.println(sm.getMin());
        sm.push(8);
        sm.push(5);
        System.out.println(sm.getMin());
    }
}
