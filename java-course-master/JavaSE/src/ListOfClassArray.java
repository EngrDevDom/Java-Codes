import java.util.ArrayList;
import java.util.Random;

public class ListOfClassArray {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        Random rand = new Random();

        int[] temp = {5, 2 ,4, 7, 0};
        ArrayList<int[]> list = new ArrayList<int[]>();

        try {
            for (int i = 0; i < temp.length; i++) {
                int[] array = new int[temp[i]];
                for (int j = 0; j < temp[i]; j++) {
                    //array[i] = 2;
                    array[i] = rand.nextInt(10);
                }
                list.add(array);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return (ArrayList<int[]>) list;

    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
            //System.out.println();
        }

    }
}
