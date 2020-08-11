public class StringOperations {
    public static void main(String[] args) {
        String fullName = " Pamela Caldwell ";

        fullName = fullName.trim();
        int indexOfSpace = fullName.indexOf(" ");
        String firstName = fullName.substring(0, indexOfSpace);
        String lastName = fullName.substring(indexOfSpace + 1, fullName.length());

        System.out.println(fullName);
        System.out.println(firstName);
        System.out.println(lastName);
    }
}