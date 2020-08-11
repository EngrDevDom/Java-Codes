package _105_One_Space_Away;

public class TesterClass {

    public static void main(String[] args) {
        test("abcd", "abc");
        test("bike", "pike");
        test("mouse", "house");
        test("take", "bake");
        test("takkkke", "bake");
    }

    private static void test(String str1, String str2) {
        System.out.println( str1 + " " +  str2 + " " + OneSpaceAway.oneSpaceAway(str1, str2));
    }
}
