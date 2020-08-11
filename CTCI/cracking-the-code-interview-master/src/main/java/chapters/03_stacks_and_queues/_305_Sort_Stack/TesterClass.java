package _305_Sort_Stack;

import java.util.Stack;

public class TesterClass {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack();

        stack.push(10);
        stack.push(9);
        stack.push(3);
        stack.push(2);
        stack.push(7);
        stack.push(5);
        stack.push(1);

        System.out.println("Stack: " + stack);
        Stack<Integer> sortedStack = SortStack.sortStack(stack);
        System.out.println("Sorted stack: " + sortedStack);
    }
}
