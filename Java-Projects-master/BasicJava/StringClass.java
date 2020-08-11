
/**
 * Write a description of class StringClass here.
 *
 * @Michael Crothers
 * @version (a version number or a date)
 */
public class StringClass
{
    public static void main(String[] args) {
        String str="This is a string variable";
        String name="Michael Crothers";
        System.out.println(str);
        System.out.println("Name: " + name);
        System.out.println(name.length());

        System.out.println(String.format("Name: %s", name));
        System.out.println(String.format("%s Name:", name));
        
        System.out.println("heLLllooOO".toUpperCase());
        System.out.println("HELLLOOoo".toLowerCase());
        System.out.println(name.toUpperCase());
        
        System.out.println("Substrings");
        System.out.println("good afternoon".substring(0,4));
        System.out.println("good afternoon".substring(5,14));
        System.out.println("good afternoon".substring(5));
        System.out.println("good afternoon".substring(5,6));
    }
}
