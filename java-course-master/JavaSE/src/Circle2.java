public class Circle2 {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle2(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle2(double radius) {
        //напишите тут ваш код
        this.radius = radius;
        x = y = 0;
    }

    public Circle2(double x, double y) {
        //напишите тут ваш код
        this( x, y, 10);

    }



    public Circle2() {

        this(5, 5, 1);
    }

    public static void main(String[] args) {

    }
}
