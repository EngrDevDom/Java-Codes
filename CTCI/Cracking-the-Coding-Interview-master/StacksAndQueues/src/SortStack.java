import java.util.Stack;

public class SortStack {

    public void sort(Stack<Integer> s) {

        // temporary stack which stores elements in sorted order but opposite direction than required
        Stack<Integer> tempStack = new Stack<>();
        int count = 0;

        while (!s.isEmpty()) {
            int item = s.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > item) {
                s.push(tempStack.pop());
            }

            tempStack.push(item);
        }

        // copying the elements back to the stack
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
        System.out.println("Sorting");
        print(s);
    }

    public void print(Stack<Integer> s){
        while(!s.isEmpty()){
            int item = s.pop();
            System.out.print(item+" ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(1);
        s.push(7);
        s.push(4);


        SortStack obj = new SortStack();
        obj.sort(s);
    }
}
