package _104_Sorted_Search_No_Size;

public class Listy {

    private int[] array;

    public Listy(int[] array) {
        this.array = array;
    }

    public int elementAt(int i) {
        if (i >= array.length) {
            return -1;
        }
        return array[i];
    }
}
