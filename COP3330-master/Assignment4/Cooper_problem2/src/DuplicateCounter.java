import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class DuplicateCounter
{
    // HashMap for storing words and associated counts
    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    // counts the number of times each word appears in a text file
    public void count(String dataFile)
    {
        String word;
        Scanner input = null;

        try
        {
            input = new Scanner(Paths.get(dataFile));
            while (input.hasNext())
            {
                word = input.next().toLowerCase().replaceAll("[\\W]", "");
                if (!wordCounter.containsKey(word))
                    wordCounter.put(word, 1);
                else
                    wordCounter.replace(word, wordCounter.get(word) + 1);
            }
        }
        catch (IOException e)
        {
            System.out.println("Friendly message that you encountered an IOException.");
            System.exit(1);
        }
        finally
        {
            // close Scanner
            if (input != null)
                input.close();
        }
    }

    // outputs the number of times each word appears to a new text file
    public void write(String outputFile)
    {
        Formatter output = null;

        try
        {
            output = new Formatter(outputFile);
            output.format("Unique Word Counts%n%n");

            // loops through entire map and writes the word and word count to the file
            for (String key : wordCounter.keySet())
                output.format("%s = %s%n", key, wordCounter.get(key));
        }
        catch (IOException e)
        {
            System.out.println("Friendly message that you encountered an IOException.");
        }
        finally
        {
            // close Formatter
            if (output != null)
                output.close();
        }
    }
}
