import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algorithms2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                //if (array[i].compareTo(array[j]) < 0) {
                if (!isGreaterThan(array[i], array[j])) {
                    String temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            //System.out.println(array[j]);
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {

        return a.compareTo(b) > 0;
    }
}
