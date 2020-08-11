public class ObjectB {
    public static void main(String[] args) {
        //2.6 String Objects: Conctatenation, Literals, and more
        //Concatenation = Combining

        String name1 = new String("Michael Crothers");
        String name2 = "Nicole Crothers";
        //Strings are object references. They are not primitives. They are made up of characters        
        System.out.println("name1: " + name1 + " name2: " + name2);
        String firstName="Gwen";
        String lastName ="Stefani";
        String fullName = "";

        //fullName = firstName + lastName;
        fullName = firstName + " " + lastName;
        //fullName += firstName;
        //fullName += lastName;
        System.out.println("fullName: " +fullName);

        //Concatenation with primitives
        int ans = 42;
        System.out.println("The answer is " + ans + ".");

        //Escape sequences
        System.out.println("\"Why are you so far away?\", she said.");
        System.out.println("\\<- That is a backslash");
        System.out.println("\nI just printed a blank line");
        System.out.println("A\tB\tC");

        //2.7 String Methods
        System.out.println(fullName);
        System.out.println("fullName length: " + fullName.length());
        System.out.println("fullName substring 0,6: " + fullName.substring(0,6));
        System.out.println("fullName substring 0,5: " + fullName.substring(0,5));
        System.out.println("fullName substring 0,4: " + fullName.substring(0,4));
        System.out.println("fullName substring 0,3: " + fullName.substring(0,3));
        //Substtring format : starting index, ending endex + 1 
        System.out.println("fullName indexOf Stefani: " + fullName.indexOf("Stefani"));
        for(int i = fullName.length(); i>=1; i--) {
            System.out.println("fullName substring 0," + i+": " +fullName.substring(0,i));
        }
        //If string does not exist or is not found in substring you will get a -1
        System.out.println("fullName indexOf stefani: " + fullName.indexOf("stefani"));

        //String Comparisons
        System.out.println("fullName equals lastName: " + fullName.equals(lastName));
        System.out.println("fullName compareTo lastName: "+ fullName.compareTo(lastName));
        //compareTo is used to compare where something is in alphabetical order
        //If it comes before in alphebetical order it will be - if it is the same it will be 0 if it is after it will be +

        // Getting one letter from a string
        // Use substring(index. index + 1)
        System.out.println("fullName substring 6,7: " + fullName.substring(6,7));
        System.out.println("fullName substring 7,8: " + fullName.substring(7,8));

        //2.8 Wrapper Classes: Integer and Double
        //Wrapper Classes == Classes that wrap around a primitive. Like an integer or double

        Integer age = new Integer(15);
        Double height = new Double(65.5);

        //int age =  15;
        //double height =  65.5;

        //Get a value from a wrapper class
        System.out.println("age: " + age.intValue());
        System.out.println("height: " +height.doubleValue());

        //MIN_VALUE AND MAX_VALUE
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE +"\n");

        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);

        //Autoboxing
        System.out.println("age: " +age);
        System.out.println("height: " +height);
        // Java Autoboxes the values. You don't have to use the methods
        Integer weight = 122;
        Double bmi = 8.7;

        //2.9 Math Class. It comes with Java and is a set of math functions
        int x = -43;
        double y = -4.3;
        //Format for static methods == Library.function() Ex) Math.abs(x);
        System.out.println("abs(x): " + Math.abs(x));
        System.out.println("abs(y): " + Math.abs(y));
        System.out.println("x squared: " +Math.pow(x, 2));
        System.out.println("20 square root: " +Math.sqrt(20));
        System.out.println("random: " +(int)(Math.random() * 100));

    }
}
