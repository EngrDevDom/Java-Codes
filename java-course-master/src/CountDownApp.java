public class CountDownApp {
    public static void main(String[] args) {
        Thread count1 = new CountDownEvenT();
        Thread count2 = new CountDownOddT();
        count1.start();
        count2.start();
    }
}

class CountDownEvenT extends Thread {
    public void run() {
        for (int i = 10; i > 0; i -= 2) {
            System.out.println(this.getName() + " Count "  + i);
            Thread.yield();
        }
    }
}

class CountDownOddT extends Thread {
    public void run() {
        for (int i = 9; i > 0; i -= 2) {
            System.out.println(this.getName() + " Count " + i);
            Thread.yield();
        }
    }
}