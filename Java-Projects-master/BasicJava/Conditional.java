
/**
 * Write a description of class Conditional here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Conditional
{
    public static void main(String[] args) {

        System.out.println("Is 3 equal to 3?");
        if(3==3) {
            System.out.println("Yes\n");
        }

        int x=21, y=345;
        System.out.println(String.format("Is %s greater than %s?", x,y));
        if(x>y) {
            System.out.println(String.format("Yes, %s is greater than %s", x,y)+"\n");   
        }
        else {
            System.out.println(String.format("No, %s is not greater than %s", x, y)+"\n");
        }
        
        String p1="rock", p2="scissors";
        
        if(p1.equals("rock") || p2.equals("rock")){
        
        System.out.println("Rock was chosen");
    }
    
    if(p1.equals("rock") && p2.equals("scissors")){
        
        System.out.println("Player 1 beats Player 2");
    }
        
        
    }
}
