package _803_Magic_Index;

public class TesterClass {

    public static void main(String[] args) {

        int[] sortedArray = { -10, 0, -1, 3, 7, 10 };
        System.out.println("Magix index is  = " + MagicIndex.getMagicIndex(sortedArray));

        int[] sortedArrayNonUnique = { -10, 1, 12, 1, 14, 6, 8, 7, 9, 12, 13 };
        System.out.println("Magix index is = " + MagicIndex.getMagicIndexNonUnique(sortedArrayNonUnique));
    }
}
