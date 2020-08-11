import java.util.ArrayList;

public class StaticCats {
    public static ArrayList<StaticCats> cats = new ArrayList<>();

    public StaticCats() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 10; i ++) {
            //      Cat cat = new Cat();
            cats.add(new StaticCats());
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for(int i = 0; i<cats.size(); i++) {
            System.out.println(cats.get(i));
        }
    }
}
