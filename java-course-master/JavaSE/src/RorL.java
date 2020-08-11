import java.util.ArrayList;

public class RorL {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        /*
        strings.add("роза");
        strings.add("лира");
        strings.add("лоза");
        */
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings.add("вода");
        strings.add("упор");

        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < strings.size(); i ++) {
            if(strings.get(i).contains("р") && strings.get(i).contains("л"))
                temp.add(strings.get(i));
            else if (strings.get(i).contains("л")) {
                temp.add(strings.get(i));
                temp.add(strings.get(i));
            } else if (!strings.get(i).contains("р") && !strings.get(i).contains("л"))
                temp.add(strings.get(i));

        }
        return temp;
    }

}
