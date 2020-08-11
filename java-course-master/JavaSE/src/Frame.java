import java.util.ArrayList;

public class Frame {
    public static void main(String[] args) {
        //напишите тут ваш код
        String s = "именно";
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");

        for (int i = 0; i <= list.size(); i ++) {
            if ((i % 2) != 0)
                list.add(i, s);
        }

        for (int i = 0; i < list.size(); i ++)
            System.out.println(list.get(i));

    }
}
