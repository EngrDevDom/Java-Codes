package _302_Minimum_Stack;

import java.util.Stack;

public class MinimumStack {


    Stack<Integer> stack = new Stack();
    Stack<Integer> minimumStack = new Stack();

    public void push(int x) {
        stack.push(x);
        if (min() == null || x <= min()) {
            minimumStack.push(x);
        }
    }

   public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        int x = stack.pop();
        if (x == minimumStack.peek()) {
            minimumStack.pop();
        }
        return x;
    }

    public Integer min() {
        if (minimumStack.isEmpty()) {
            return null;
        } else {
            return minimumStack.peek();
        }
    }
}
