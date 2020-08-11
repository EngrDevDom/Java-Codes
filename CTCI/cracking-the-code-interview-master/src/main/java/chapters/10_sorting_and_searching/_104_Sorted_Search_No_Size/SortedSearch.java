package _104_Sorted_Search_No_Size;

/**
 * Sorted Search, No Size; You are given an array-like data structure Li st y which lacks a size
 * method. It does, however, have an elemen t At (i ) method that returns the element at index i in
 * 0(1 ) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
 * structure only supports positive integers.) Given a List y which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 */
public class SortedSearch {

    public static int sortedSearch(Listy list, int value) {

        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySortedSearch(list, value, index / 2, index);
    }

    public static int binarySortedSearch(Listy list, int value, int start, int end) {

        while (start <= end) {
            int middle = (start + end) / 2;
            int middleValue = list.elementAt(middle);
            if (middleValue == -1 || middleValue > value) {
                end = middle - 1;
            } else if (middleValue < value) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


}
