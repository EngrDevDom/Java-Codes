package _302_Minimum_Stack;

public class TesterClass {

    public static void main(String[] args) {

        MinimumStack stack = new MinimumStack();

        stack.push(10);
        stack.push(5);
        stack.push(7);
        System.out.println(" Minimum  = " + stack.min());
        stack.push(1);
        System.out.println(" Minimum  = " + stack.min());
        stack.push(0);
        stack.push(20);
        stack.push(13);
        System.out.println(" Minimum  = " + stack.min());
        stack.pop();
        System.out.println(" Minimum = " + stack.min());
    }
}
