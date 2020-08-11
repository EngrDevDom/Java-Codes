package _109_Sorted_Matrix_Search;

public class TesterClass {

    public static void main(String[] args) {
        int[][] matrix =
                {{ 1,  5,  7,  9 },
                { 4,  8,  9, 11 },
                { 6,  9, 11, 15 },
                { 17, 14, 19, 22 }};
        System.out.println(SortedMatrixSearch.searchMatrix(matrix, 6));
        System.out.println(SortedMatrixSearch.searchMatrix(matrix, 9));
        System.out.println(SortedMatrixSearch.searchMatrix(matrix, 14));
        System.out.println(SortedMatrixSearch.searchMatrix(matrix, 10));
        System.out.println(SortedMatrixSearch.searchMatrix(matrix, 100));
    }
}
