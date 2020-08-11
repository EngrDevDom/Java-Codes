package _105_Sparse_Search;

/**
 * Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
 * method to find the location of a given string.
 */
public class SparseSearch {


    public static int searchWord(String[] words, String word) {
        if (words == null || words.length == 0 || word.isEmpty() || word == null) {
            return -1;
        }
        return binarySearchForWord(words, word, 0, words.length - 1);
    }

    private static int binarySearchForWord(String[] words, String word, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        //if middle is empty, find the next non empty string
        if (words[middle].isEmpty()) {
            int left = middle - 1;
            int right = middle + 1;
            while (true) {
                if (left < start && right > end) {
                    return -1;
                } else if (right <= end && !words[right].isEmpty()) {
                    middle = right;
                    break;
                } else if (left >= start && !words[left].isEmpty()) {
                    middle = left;
                    break;
                }
            }
            right++;
            left--;
        }

        if (word.equals(words[middle])) {
            return middle;
        } else if (words[middle].compareTo(word) < 0) {
            return binarySearchForWord(words, word, middle + 1, end);
        } else {
            return binarySearchForWord(words, word, start, middle - 1);
        }

    }

}
