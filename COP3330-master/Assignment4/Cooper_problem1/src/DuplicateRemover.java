import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class DuplicateRemover
{
    // set for storing unique words
    Set<String> uniqueWords = new HashSet<String>();

    // stores words in the uniqueWords set without duplicates
    public void remove(String dataFile)
    {
        Scanner input = null;
        try
        {
            input = new Scanner(Paths.get(dataFile));
            while (input.hasNext())
                uniqueWords.add(input.next().toLowerCase().replaceAll("[\\W]", ""));
        }
        catch (IOException e)
        {
            System.out.println("Friendly message that your program caused an IOException");
            System.exit(1);
        }
        finally
        {
            // close Scanner
            if (input != null)
                input.close();
        }
    }

    // writes unique words to specified output file
    public void write(String outputFile)
    {
        Formatter output = null;
        Iterator<String> it = uniqueWords.iterator();

        try
        {
            output = new Formatter(outputFile);
            output.format("Unique Words%n%n");
            while (it.hasNext())
                output.format("%s%n", it.next());
        }
        catch (IOException e)
        {
            System.out.println("Friendly message that your program caused an IOException");
        }
        finally
        {
            // close Formatter
            if (output != null)
                output.close();
        }
    }

}
