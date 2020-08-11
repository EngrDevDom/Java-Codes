
/**
 * Write a description of class HashMap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap; // import the HashMap class
public class Hash
{
    public static void main(String[] args) {
        HashMap<String, String> capitals = new <String, String> HashMap();
        String country, capital;
        capitals.put("Japan", "Tokyo");
        capitals.put("China", "Bejing");
        capitals.put("America", "Wahsington D.C.");
        
        capital = capitals.get("Japan");
        System.out.println("Japan: " + capital +"\n");
        
        country = "America";
        capital= capitals.get(country);
        System.out.println(country + ": " + capital +"\n");
        for(String countryName: capitals.keySet()) {
            capital = capitals.get(countryName);
            System.out.println(countryName + ": " + capital);
        }
        System.out.println();
        for( String i: capitals.keySet()) {
            System.out.println(i);
        }
        
        System.out.println("\n\n\n\n");
        HashMap<String, Integer> people= new HashMap<String, Integer>();
        people.put("Michael", 14);
        people.put("Nicole", 19);
        people.put("Dad", 62);
        people.put("Mom", 55);
        for(String x: people.keySet()) {
            System.out.println("Name: " + x + " Age: " + people.get(x));
        }
        
        
    }
}
