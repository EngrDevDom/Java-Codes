import java.util.Stack;

public class QueueViaStack {

    static class MyQueue<T>{
        Stack<T> stackOldest;
        Stack<T> stackNewest;

        MyQueue(){
            stackOldest = new Stack<>();
            stackNewest = new Stack<>();
        }

        public void add(T item){
            if(!stackOldest.isEmpty()){
                while(!stackOldest.isEmpty()){
                    T data = stackOldest.pop();
                    stackNewest.push(data);
                }
            }
            stackNewest.push(item);
        }

        public T remove(){
            while(!stackNewest.isEmpty()){
                T data = stackNewest.pop();
                stackOldest.push(data);
            }
            if(stackOldest.isEmpty()){
                return null;
            }
            return stackOldest.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> qv = new MyQueue<>();
        qv.add(2);
        qv.add(7);
        qv.add(8);
        System.out.println(qv.remove());
        qv.add(5);
        System.out.println(qv.remove());

    }
}
