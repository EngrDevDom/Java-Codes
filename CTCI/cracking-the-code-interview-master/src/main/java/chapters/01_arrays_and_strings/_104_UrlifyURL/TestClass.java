package _104_UrlifyURL;

public class TestClass {
    public static void main(String[] args) {
        String test = "this  is  a test   ";
        urlifyString(test, test.length() );
    }

    private static void urlifyString(String string, int length) {
        char[] url = string.toCharArray();
        System.out.println(url);
        UrlifyUrl.replaceWhitespaces(url, length);
        System.out.println(url);
    }
}
