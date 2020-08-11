package _1505_Call_In_Order;

public class TesterClass {

    public static void main(String[] args) {
        CallInOrder callInOrder = new CallInOrder();

        TestThread t1 = new TestThread(callInOrder, "firstMethod");
        TestThread t2 = new TestThread(callInOrder, "secondMethod");
        TestThread t3 = new TestThread(callInOrder, "thirdMethod");

        t3.start();
        t2.start();
        t1.start();
    }
}
