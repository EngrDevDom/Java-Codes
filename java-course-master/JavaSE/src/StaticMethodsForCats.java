public class StaticMethodsForCats {
    private static int catCount = 0;

    public StaticMethodsForCats() {
        catCount++;
    }

    public static int getCatCount() {
        //напишите тут ваш код
        return catCount;

    }

    public static void setCatCount(int catCount) {
        //напишите тут ваш код
        StaticMethodsForCats.catCount = catCount;

    }

    public static void main(String[] args) {

    }
}
