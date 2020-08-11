import java.util.Scanner;

public class CountInterruptApp {
    public static void main(String[] args) {
        Thread counter = new Counter();
        counter.start();
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (!s.equals("stop"))
            s = sc.next();
        counter.interrupt();
    }
}

class Counter extends Thread {
    public void run() {
        int count = 0;
        while (!isInterrupted()) {
            System.out.println(this.getName() + " Count " + count);
            count ++;
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Counter interrupted.");
    }
}
