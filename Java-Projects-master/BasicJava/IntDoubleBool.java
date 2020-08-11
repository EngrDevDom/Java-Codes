/**
 * Write a description of class IntDoubleBool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntDoubleBool
{
    public static void main(String[] args) {
        int i = 33;
        double d=3.3;
        boolean isNeat=true;

        System.out.println(i);
        System.out.println(d);
        System.out.println(isNeat);

        System.out.println("Addition: "+(i+d));
        System.out.println("Subtraction: " + (i-d));
        System.out.println("Multiplication: "+i*d);
        System.out.println("Division: "+i/d);
        System.out.println("Modulus: "+i%d);

        System.out.println("\ni = "+ i);
        System.out.println(String.format("i = %s", i));

        System.out.println("\n"+isNeat);
        if(isNeat) {
            System.out.println("I really am neat");
        }
        else {
            System.out.println("Feels bad man, I'm not neat");
        }        
    }
}
