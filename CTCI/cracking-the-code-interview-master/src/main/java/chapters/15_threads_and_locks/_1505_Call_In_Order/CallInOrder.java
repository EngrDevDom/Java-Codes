package _1505_Call_In_Order;

import java.util.concurrent.Semaphore;

public class CallInOrder {

    public Semaphore semaphore1;
    public Semaphore semaphore2;
    public int pauseTime = 1000;


    public CallInOrder() {

        try {
            semaphore1 = new Semaphore(1);
            semaphore2 = new Semaphore(1);

            semaphore1.acquire();
            semaphore2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void firstMethod() {
        try {
            System.out.println("Started executing method 1");
            TestThread.sleep(pauseTime);
            System.out.println("Finished executing method 1");
            semaphore1.release();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void secondMethod() {
        try {
            semaphore1.acquire();
            semaphore1.release();
            System.out.println("Started executing method 2");
            TestThread.sleep(pauseTime);
            System.out.println("Finished executing method 2");
            semaphore2.release();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void thirdMethod() {
        try {
            semaphore2.acquire();
            semaphore2.release();
            System.out.println("Started executing method 3");
            TestThread.sleep(pauseTime);
            System.out.println("Finished executing method 3");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
