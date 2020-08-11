
/**
 * Write a description of class Array here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Array
{
    public static void main(String[] args) {
        int[] scores= new int[3];
        scores[0] = 85;
        scores[1] = 99;
        scores[2] = 123;

        System.out.println(scores[0]+ "\n");
        for(int i=0; i<scores.length; i++) {
            System.out.println("Score " +i +": " +scores[i]);
        }

        double average = (scores[0]+scores[1]+scores[2]) / scores.length;
        System.out.println("Average Score: " + average + "\n");

        int weights[] = {110, 232, 231, 150, 143, 174, 161};
        for( int i=0; i<weights.length; i++) {
            System.out.println("Weight "+ i+ ": " + weights[i]);
        }
        System.out.println();
        for(int weight: weights) {
            System.out.println(weight);
        }     
    }
}
