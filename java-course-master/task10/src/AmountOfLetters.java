import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmountOfLetters {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');


        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        int count = 0;

        for ( char x : alphabet)
        {
            for ( String y : list)
            {
                for (char z : y.toCharArray())
                {
                    if ( x == z )
                        count ++;
                }
            }
            System.out.println(x + " " + count);
            count = 0;
        }

    }
}
