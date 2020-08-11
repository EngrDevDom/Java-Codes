import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrameWashing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код

        String s = string.trim();

        String[] arr = s.split(" +");

        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }


        System.out.println(sb.toString().trim());
    }
}
