
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public static void makeZero(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static void makeZeroOptimised(int[][]matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isCol = false;

        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                isCol = true;
            }
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] =0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j=0;j<n;j++){
                matrix[0][j] = 0;
            }
        }
        if(isCol){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{2,3,4},{6,7,0},{4,5,3},{0,3,4}};
        print(matrix);
        System.out.println("After zeroing: ");
        makeZeroOptimised(matrix);
        print(matrix);
    }
}
