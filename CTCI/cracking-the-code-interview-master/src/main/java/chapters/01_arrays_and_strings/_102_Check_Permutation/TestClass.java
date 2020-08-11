package _102_Check_Permutation;

public class TestClass {


    public static void main(String[] args) {
        test("hello", "oelhl");
        test("world", "word");
    }

    private static void test(String str1, String str2) {
        System.out.format("%s, %s: %s\n", str1, str2, CheckStringPermutations.isPermutation(str1, str2));
    }
}
