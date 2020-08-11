//public final class Book extends Product {
public class Book extends Product {
    private String author;

    public Book() {
        super();
        author = "";
        count ++;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "Author:      " + author + "\n";
//    }
    public String getDisplayText() {
        return super.toString() + "Author:      " + author + "\n";
    }
//    public final String getDisplayText() {
//        return super.toString() + "Author:      " + author + "\n";
//    }
}
