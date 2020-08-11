package _303_Stack_Of_Plates;

public class TesterClass {

    public static void main(String[] args) {

        StackOfPlates stack = new StackOfPlates();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Pushed element: " + i);
            stack.push(i);
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}
