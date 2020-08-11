public class RotateMatrix {

    public static void rotate(int[][]matrix){
        int n = matrix.length;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }
    }

    // 2nd method: transpose and reverse
    public static void rotateTranspose(int[][]matrix){
        int n = matrix.length;

        // transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse the columns
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = temp;
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

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        print(matrix);
        System.out.println("After rotation: ");
        rotateTranspose(matrix);
        print(matrix);
    }
}
