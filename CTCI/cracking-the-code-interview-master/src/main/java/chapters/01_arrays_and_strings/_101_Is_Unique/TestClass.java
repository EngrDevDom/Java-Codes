package _101_Is_Unique;

public class TestClass {

    public static void main(String[] args) {
        test("Abcdefghijkl");
        test("Aabcd");
        test("XyzSaX");
    }

    private static void test(String str) {

        System.out.format("%8s: %s%n", str, IsStringComposedFromUniqueChars.areUniqueCharacters(str));
    }

}
