package _109_String_Rotation;

public class StringRotation {

    public static boolean areStringRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String doubleString = str1 + str1;
        return doubleString.contains(str2);
    }


}
