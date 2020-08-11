public class QueueOrderApp {
    public static void main(String[] args) {
        final int TAKER_COUNT = 3;
        final int ORDER_COUNT = 3;
        final int HANDLER_COUNT = 2;

        OrderQueue queue = new OrderQueue();
        System.out.println("Starting the order queue.");
        System.out.println("Starting " + TAKER_COUNT + " order taker threads, "
                            + "each producing " + ORDER_COUNT + " orders.");
        System.out.println("Starting " + HANDLER_COUNT + " order handler threads.\n");

        String s = "    OrderTaker threads  \t  OrderHandler threads    \n"
                 + "=====================================================";

        for (int i = 0; i < TAKER_COUNT; i ++) {
            OrderTaker t = new OrderTaker(ORDER_COUNT, queue);
            t.start();
        }
        for (int i = 0; i < HANDLER_COUNT; i ++) {
            OrderHandler h = new OrderHandler(queue);
            h.start();
        }
    }
}
