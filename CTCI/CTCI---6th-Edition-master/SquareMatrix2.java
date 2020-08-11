import java.util.Arrays;

class SquareMatrix2 {

    public static void main(String[] args) {
        
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        SquareMatrix2 sq = new SquareMatrix2();
        int[][] rot = sq.rotate(arr);
        System.out.println(Arrays.toString(rot));
    }

    int[][] rotate(int[][] arr){
        int[][] arrt = new int[arr.length][arr[0].length];
        if(arrt.length == 0 || arrt.length != arrt[0].length){
            System.out.println("not a square matrix");
        }
        int n = arrt.length;

        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i < last ; i++){
                int offset = i - first;
                int top = arrt[first][i]; //save top

                //left -> top
                arrt[first][i] = arrt[last - offset][first];

                //bottom -> left
                arrt[last - offset][first] = arrt[last][last-offset];
                
                //rigth -> bottom
                arrt[last][last-offset] = arrt[i][last];

                //top -> right
                arrt[i][last]  = top;
            }
        }
        return arrt;
    }
}
