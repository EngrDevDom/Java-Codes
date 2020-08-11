package _305_Sort_Stack;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack();
        while (!stack.isEmpty()) {
            Integer currentElement = stack.pop();
            while (!tempStack.isEmpty() && currentElement < tempStack.peek()) {
                stack.push(tempStack.pop());
            }
            tempStack.push(currentElement);
        }
        return tempStack;
    }
}
