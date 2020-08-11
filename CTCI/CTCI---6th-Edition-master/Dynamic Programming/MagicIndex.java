/**
 * MagicIndex
 */
public class MagicIndex {

    public static int magicIndex(int[] arr,int start, int end) {
        if(end < start){
            return -1;
        }

        int mid = (start+end)/2;
        if(arr[mid] == mid){
            return mid;
        }else if(arr[mid] > mid){
            return magicIndex(arr, start, mid-1);
        }else{
            return magicIndex(arr, mid+1, end);
        }
    }

    public static int magicIndex(int[] arr) {
        return magicIndex(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {-2,-4,-3,1,2,3,4,7,5,6};
        int n = magicIndex(arr);
        System.out.println(n);
    }
}