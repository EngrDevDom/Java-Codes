public class CountDownSleepApp {
    public static void main(String[] args) {
        Thread count1 = new CountDownEvenS();
        Thread count2 = new CountDownOddS();
        count1.start();
        count2.start();
    }
}
class CountDownEvenS extends Thread {
    public void run() {
        for (int i = 10; i > 0; i -= 2) {
            System.out.println(this.getName() + " Count " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {}
        }
    }
}
class CountDownOddS extends Thread {
    public void run() {
        for (int i = 9; i > 0; i -= 2) {
            System.out.println(this.getName() + " Count " + i);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {}
        }
    }
}