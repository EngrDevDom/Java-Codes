public class OrderTaker extends Thread {
    private static int orderNumber = 1;
    private int count = 0;
    private int maxOrders;
    private OrderQueue orderQueue;

    public OrderTaker(int maxOrders, OrderQueue orderQueue) {
        this.maxOrders = maxOrders;
        this.orderQueue = orderQueue;
    }
    public void run() {
        Order order;
        while (count < maxOrders) {
            order = new Order(getOrderNumber());
            orderQueue.pushOrder(order);
            System.out.println(order.toString() + " created by " + this.getName());
            count ++;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {}
        }
    }
    private synchronized int getOrderNumber() {
        return orderNumber ++;
    }
}
