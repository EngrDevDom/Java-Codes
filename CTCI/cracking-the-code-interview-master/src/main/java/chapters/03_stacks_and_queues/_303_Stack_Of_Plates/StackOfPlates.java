package _303_Stack_Of_Plates;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {

    private ArrayList<Stack<Integer>> stackList = new ArrayList<>();
    private final int stackCapacity = 5;

    public void push(int value) {

        Stack<Integer> lastStack = getLastStack();
        if (lastStack != null && lastStack.size() < stackCapacity) {
            lastStack.push(value);
        } else {
            //create a new stack and push element into it
            Stack<Integer> newStack = new Stack();
            newStack.push(value);
            stackList.add(newStack);
        }
    }

    public Integer pop() {

        Stack<Integer> lastStack = getLastStack();

        if (lastStack == null) {
            return null;
        } else {
            Integer result = lastStack.pop();
            if (lastStack.isEmpty()) {
                stackList.remove(stackList.size() - 1);
            }
            return result;
        }
    }

    public Stack<Integer> getLastStack() {
        if (stackList.isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }
}
