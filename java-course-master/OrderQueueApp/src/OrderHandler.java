public class OrderHandler extends Thread {
    private OrderQueue orderQueue;

    public OrderHandler(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        Order order;
        while (true) {
            order = orderQueue.pullOrder();
            System.out.println("\t\t\t\t" + order.toString() + " prcessed by " + this.getName());
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {}
        }
    }
}
