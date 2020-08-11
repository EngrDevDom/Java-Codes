public class Card {
    private String name;
    private String suit;
    private int value;
    // 5.2 Constructors
    public Card() {
        System.out.println("I am a new card.");
    }

    public Card(String myName, String mySuit, int myValue) {
        name = myName;
        suit = mySuit;
        value = myValue;
        System.out.println("I am a " + name + " of " + suit + " with a value of " + value +".");
        int x = 10;
        System.out.println("x: " + x);
        //Scope is only in this constructor. Can't be accessed from anywhere else.
        //Not defined outside of method.
        // X dissapears
    }
    //5.4 Accessor Methods
    public String getName() {
        return name;        
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "Name: " + name + " Suit: " + suit + " Value: " + value;
    }

    //5.5 Mutator Methods
    public void setName(String newName) {
        name = newName;
    }

    public void setSuit(String newSuit) {
        suit = newSuit;
    }

    public void setValue(int newValue) {
        value = newValue;
    }
    //5.6 Writing methods
    public void printCard() {
        System.out.println("+---+");
        System.out.println("|" +suit+"--|");
        System.out.println("|-"+name+"-|");
        System.out.println("|--"+suit+"|");
        System.out.println("+---+");
    }
    //5.7 Static Methods, attached to the class itself.
    public static void printCard(String name, String suit){
        System.out.println("+---+");
        System.out.println("|" +suit+"--|");
        System.out.println("|-"+name+"-|");
        System.out.println("|--"+suit+"|");
        System.out.println("+---+");
    }

}
