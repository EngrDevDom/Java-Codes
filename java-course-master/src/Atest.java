public class Atest {
    public static void main(String[] args) {
        String s = "durbek kosimov";
        s = s.trim();
        int index = s.indexOf(" ");
        System.out.println(index);
        if (index == -1)
            System.out.println("Wrong name");
        else {
            int index2 = s.indexOf(" ", index + 1);
            System.out.println(index2);
        }
    }
}
