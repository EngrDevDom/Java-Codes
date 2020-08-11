import java.io.IOException;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words.txt");
    }
}

