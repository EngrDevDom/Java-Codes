import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Jolushka {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> int3 = new ArrayList<Integer>();
        ArrayList<Integer> int2 = new ArrayList<Integer>();
        ArrayList<Integer> int32 = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++)
            nums.add(Integer.parseInt(reader.readLine()));

        for (int i = 0; i < nums.size(); i ++) {
            if (nums.get(i) % 3 == 0)
                int3.add(nums.get(i));
        }

        for (int i = 0; i < nums.size(); i ++) {
            if (nums.get(i) % 2 == 0)
                int2.add(nums.get(i));
        }

        for (int i = 0; i < nums.size(); i ++) {
            if (nums.get(i) % 3 != 0 && nums.get(i) % 2 != 0)
                int32.add(nums.get(i));
        }

        printList(int3);
        printList(int2);
        printList(int32);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i ++)
            System.out.println(list.get(i));
    }
}
