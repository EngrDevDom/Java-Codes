public class DisplayableTestApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Displayable Test application\n");

        Employee e = new Employee(2, "Smith", "John");
        // TODO: add code that passes this object to the display method below
        displayMultiple(e, 1);

        Product p = new Product("java", "Murach's Java Programming", 57.50);
        // TODO: add code that passes this object to the display method below
        displayMultiple(p, 2);

        System.out.println();
    }

    private static void displayMultiple(Displayable d, int count) {
        for (int i = 0; i < count; i ++)
            System.out.println(d.getDisplayText() + (i+1) );
    }
//
//    private static String displayMultiple(Displayable d, int count) {
//        String s = "";
//        s = d.getDisplayText();
//        return s;
//    }

}