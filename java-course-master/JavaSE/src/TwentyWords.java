import java.util.HashSet;
import java.util.Set;

public class TwentyWords {
    public static Set<String> createSet() {
        //напишите тут ваш код
        Set<String> sett = new HashSet<String>();
        for (int i = 0; i < 20; i ++)
            sett.add("Л" + i);
        return  sett;
    }

    public static void main(String[] args) {

    }
}
