package _1505_Call_In_Order;

public class TestThread extends Thread {

    private String methodName;
    private CallInOrder callInOrder;

    public TestThread(CallInOrder callInOrder, String method) {
        this.callInOrder = callInOrder;
        this.methodName = method;
    }

    @Override
    public void run() {
        if (methodName.equals("firstMethod")) {
            callInOrder.firstMethod();
        } else if (methodName.equals("secondMethod")) {
            callInOrder.secondMethod();
        } else if (methodName.equals("thirdMethod")) {
            callInOrder.thirdMethod();
        }
    }
}
