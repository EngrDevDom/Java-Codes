public class ComparesStrings {
    public static void main(String[] args) {
        String lastName1 = "Smith";
        String lastName2 = "Lee";
        int sortResult = lastName1.compareToIgnoreCase(lastName2);
        if (sortResult < 0)
            System.out.println(lastName1 + " comes first.");
        else if (sortResult == 0)
            System.out.println("The names are the same.");
        else
            System.out.println(lastName2 + " comes first");
    }
}
