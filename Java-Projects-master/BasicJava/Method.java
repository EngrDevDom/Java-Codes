
/**
 * Write a description of class Method here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Method
{
    public static void main(String[] args) {
        System.out.println("Hello");
        printPi();
        System.out.println("World");
        System.out.println("Print Double");
        printDouble(54.465789);

        System.out.println("Get Pi");
        double pi=getPi();
        System.out.println(pi);

        System.out.println("Get Int");
        int d= getInt(16);
        System.out.println(d + "\n");

        System.out.println("Get Greater Number");
        int greatest = getGreatest(42, 1001);
        System.out.println(greatest);
    }

    public static void printPi(){
        System.out.println(3.14159);
    }

    public static void printDouble(double x) {
        System.out.println(x *2);   
    }

    public static double getPi(){
        return 3.14159;
    }

    public static int getInt(int x) {
        return x*2;   
    }

    public static int getGreatest(int x, int y) {
        if( x > y) {
            return x;
        }
        else {
            return y;
        }
    }
}
