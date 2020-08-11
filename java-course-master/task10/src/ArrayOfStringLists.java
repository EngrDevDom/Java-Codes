import java.util.ArrayList;

public class ArrayOfStringLists {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        ArrayList<String>[] alist = new ArrayList[10];
        for (int i = 0; i < alist.length; i ++) {
            alist[i] =  new ArrayList<String>();
            alist[i].add("r" + i);
        }

        return alist;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
