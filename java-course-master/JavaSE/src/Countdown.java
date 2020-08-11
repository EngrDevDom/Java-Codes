public class Countdown {
    public static void main(String[] args) {
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);

            //напишите тут ваш код
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Бум!");
    }
}
