package _804_Power_Set;

        import java.util.Arrays;
        import java.util.List;

public class TesterClass {

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 9, 5};
        System.out.println(Arrays.toString(array));
        List<List<Integer>> subsets = PowerSet.getSubsets(array);
        System.out.println("Subsets: " + subsets);

    }


}
