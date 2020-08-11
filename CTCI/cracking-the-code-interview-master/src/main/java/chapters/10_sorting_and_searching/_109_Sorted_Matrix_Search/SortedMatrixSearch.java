package _109_Sorted_Matrix_Search;


/**
 * Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
 * ascending order, write a method to find an element.
 */
public class SortedMatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int element) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        //start at top-right corner
        int row = 0;
        int col = columns - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == element) {
                return true;
            } else if (matrix[row][col] > element) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


}
