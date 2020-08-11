public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        double x, y, a;
        x = x2 - x1;
        y = y2 - y1;
        a = x * x + y * y;
        return Math.sqrt(a);
    }

    public static void main(String[] args) {

    }
}
