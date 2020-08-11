package _103_Palindrome_Permutation;

public class TestClass {

    public static void main(String[] args) {
        test("coal loac");
        test("abba abbc");
    }

    private static void test(String word) {
        System.out.println(word + ": " + PalindromePermutation.palindromePermutation(word));
    }
}
