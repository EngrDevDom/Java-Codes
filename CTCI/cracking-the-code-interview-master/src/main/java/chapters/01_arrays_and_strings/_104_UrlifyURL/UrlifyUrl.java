package _104_UrlifyURL;

public class UrlifyUrl {

    public static void replaceWhitespaces(char[] url, int length) {
        int numberOfSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (url[i] == ' ') {
                numberOfSpaces++;
            }
        }
        if (numberOfSpaces > 0) {
            int j = length - 1 + numberOfSpaces * 2;
            for (int i = length - 1; i >= 0; i--) {
                if (url[i] == ' ') {
                    url[j-2] = '%';
                    url[j-1] = '2';
                    url[j]   = '0';
                    j = j - 3;
                } else {
                    url[j] = url[i];
                    j--;
                }
            }
        }
    }
}
