package _105_One_Space_Away;

public class OneSpaceAway {

    public static boolean oneSpaceAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return oneEditReplaceCharacter(str1, str2);
        } else if (str1.length() == str2.length() + 1) {
            return oneEditInsert(str1, str2);
        } else if (str1.length() + 1 == str2.length()) {
            return oneEditInsert(str2, str1);
        }
        return false;
    }

    private static boolean oneEditReplaceCharacter(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int mismatches = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                mismatches++;
            }
            if (mismatches > 1) {
                return false;
            }
        }
        return true;
    }

    private static Boolean oneEditInsert(String str1, String str2) {
        if (str1.length() != str2.length() + 1) {
            return null;
        }
        int i = 0, j = 0;
        int insert = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                insert++;
            }
            if (insert > 1) {
                return false;
            }
        }
        return true;
    }


}
