import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryCatch {
    public static void main(String[] args) {

        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int a = Integer.parseInt(reader.readLine());
                System.out.println(a);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
