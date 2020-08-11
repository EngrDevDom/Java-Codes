package _109_String_Rotation;

public class TesterClass {


    public static void main(String[] args) {
        test("house", "esuoh");
        test("tate", "etat");
        test("army", "yarmy");
    }

    private static void test(String str1, String str2) {
        System.out.println(str1 + ", " + str2 + "  --> " + StringRotation.areStringRotation(str1, str2));
    }
}
