public class CountDownRunnableApp {
    public static void main(String[] args) {
        Thread count1 = new Thread(new CountDownEven());
        Thread count2 = new Thread(new CountDownOdd());
        count1.start();
        count2.start();
    }
}
class CountDownEven implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 10; i > 0; i -= 2) {
            System.out.println(t.getName() + " Count " + i);
            Thread.yield();
        }
    }
}

class CountDownOdd implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 10; i > 0; i -= 2) {
            System.out.println(t.getName() + " Count " + i);
            Thread.yield();
        }
    }
}
