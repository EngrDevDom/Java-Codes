package _304_Queue_With_Stacks;

public class TesterClass {

    public static void main(String[] args) {

        QueueWithStacks<Integer> queue = new QueueWithStacks<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println("First element dequeued = " + queue.remove());
        queue.add(7);
        queue.add(8);
        System.out.println("Second element dequeued = " + queue.remove());
        System.out.println("Third element dequeued = " + queue.remove());
        System.out.println("Fourth element dequeued = " + queue.remove());
        System.out.println("Fifth element dequeued = " + queue.remove());
        System.out.println("Sixth element dequeued = " + queue.remove());
        System.out.println("Seventh element dequeued = " + queue.remove());
        System.out.println("Eighth element dequeued = " + queue.remove());
        System.out.println("No element dequeued = " + queue.remove());
    }
}
