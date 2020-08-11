package _105_Sparse_Search;

public class TesterClass {

    public static void main(String[] args) {
        String[] words = {"airplane", "", "", "bar", "" ,"", "car", " ", "done", "one", "" , "two"};
        System.out.println("Search for \"airplane\" " + SparseSearch.searchWord(words,"airplane"));
        System.out.println("Search for \" two\" " + SparseSearch.searchWord(words,"two"));
        System.out.println("Search for \" bar\" " + SparseSearch.searchWord(words,"bar"));
        System.out.println("Search for \" car\" " + SparseSearch.searchWord(words,"car"));

    }
}
