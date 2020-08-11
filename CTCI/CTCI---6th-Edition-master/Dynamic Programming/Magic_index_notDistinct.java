public class Magic_index_notDistinct {
    //Note: returns the first solution even if other exists

    public static int magicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = arr[mid];

        if (arr[mid] == mid) {
            return mid;
        }
        //searchLeft
        int leftIndex = Math.min(mid-1, midValue);
        int left = magicIndex(arr, start, leftIndex);
        if(left>=0) return left;

        //searchRight
        int rightIndex = Math.max(mid+1, midValue);
        int right = magicIndex(arr, rightIndex, end);
        return right;
    }

    public static int magicIndex(int[] arr) {
        return magicIndex(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 1, 2, 3, 4, 7, 5, 6 };
        int n = magicIndex(arr);
        System.out.println(n);
    }
}