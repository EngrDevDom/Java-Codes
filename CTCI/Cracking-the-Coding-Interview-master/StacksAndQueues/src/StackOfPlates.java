import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackOfPlates<T> {

    ArrayList<Stack<T>> stacks ;
    int capacity = 3;

    StackOfPlates(){
        stacks = new ArrayList<>();
    }

    public void push(T x){
        if(stacks.size() == 0){
            createStackAndPush(x);
        }else{
            Stack<T> last = getLastStack();
            if(last != null){
                if(last.size() >= capacity){
                    createStackAndPush(x);
                }else{
                    last.push(x);
                }
            }
        }
    }

    public Stack<T> getLastStack(){
        if(stacks.size() == 0){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }

    public void createStackAndPush(T x){
        Stack<T> stack = new Stack<T>();
        stack.push(x);
        stacks.add(stack);
    }

    public int pop(){
        Stack<T> last = getLastStack();
        if(last == null){
            throw new EmptyStackException();
        }
        T item = last.pop();
        if(last.size() == 0){
            stacks.remove(stacks.size()-1);
        }
        return (int)item;

    }

    public T popAtIndex(int stackNum){
        if(stackNum >= stacks.size()){
            return null;
        }
        return stacks.get(stackNum).pop();
    }

    public int size(){
        if(stacks.isEmpty()){
            return 0;
        }
        int totalSize = 0;
        for(Stack stack: stacks){
            totalSize += stack.size();
        }
        return totalSize;

    }
    public static void main(String[] args) {

        StackOfPlates<Integer> sp = new StackOfPlates<Integer>();
        sp.push(23);
        sp.push(44);
        System.out.println(sp.pop());
        System.out.println(sp.size());
        sp.push(37);
        sp.push(98);
        sp.push(56);
        sp.push(11);
        System.out.println(sp.pop());
        System.out.println(sp.popAtIndex(0));
        System.out.println(sp.size());
    }
}
