package _104_Sorted_Search_No_Size;

public class TesterClass {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 8, 9, 11, 19, 21, 24, 28, 50, 69, 73};
        Listy list = new Listy(array);
        System.out.println("Search for 3: " + SortedSearch.sortedSearch(list, 3));
        System.out.println("Search for 21: " + SortedSearch.sortedSearch(list, 21));
        System.out.println("Search for 28: " + SortedSearch.sortedSearch(list, 28));
        System.out.println("Search for 73: " + SortedSearch.sortedSearch(list, 73));
        System.out.println("Search for 79 (should be -1) : " + SortedSearch.sortedSearch(list, 79));
    }
}
