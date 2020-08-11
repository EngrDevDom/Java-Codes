package _304_Queue_With_Stacks;

import java.util.Stack;

public class QueueWithStacks<E> {

    private Stack<E> firstStack = new Stack<>();//add elements in the firstStack
    private Stack<E> secondStack = new Stack<>();//remove elements from the secondStack

    public void add(E element) {
        firstStack.push(element);
    }

    public E remove() {
        if (size() == 0) {
            return null;
        }
        if (secondStack.isEmpty()) {
            shiftElementsFromStacks();
        }
        return secondStack.pop();
    }

    public E peek() {

        if (size() == 0) {
            return null;
        }
        if (secondStack.isEmpty()) {
            shiftElementsFromStacks();
        }
        return secondStack.peek();

    }

    public int size() {
        return firstStack.size() + secondStack.size();
    }

    private void shiftElementsFromStacks() {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
    }


}
