
/**
 * Write a description of class loop here.
 *
 * @author (your name) Michael Crothers
 * @version (a version number or a date)
 */
public class loop
{
    public static void main(String[] args) {
        String title="Hello", word="kachiga";
        for(int i=0; i<=10; i++){
            System.out.println(i);
        }
        System.out.println();
        for(int i=0; i<=10; i=i+2){
            System.out.println(i);
        }
        System.out.println();
        for(int i=10; i>=0; i--){
            System.out.println(i);
        }

        System.out.println();
        for(int i=10; i>=0; i--){
            System.out.print(i +" ");
        }
        System.out.println();
        for(int i=0; i<title.length(); i++) {
            char letter=title.charAt(i);
            System.out.print(letter);
        }
        System.out.println();

        for(int i=0; i<title.length(); i++) {
            System.out.println(title.substring(i, i=i+2));
        }

        System.out.println(title.substring(0,5));

        System.out.println();
        for(char letter: word.toCharArray()) {
            System.out.println(letter);
        }

        System.out.println();

        int i=0;
        while(i<word.length()) {
            char letter=word.charAt(i);
            System.out.println(letter);
            i++;
        }
    }    
}
