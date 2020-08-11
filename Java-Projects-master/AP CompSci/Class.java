public class Class {
  public static void main(String[] args) {
      //5.1 Classes define objects which have attributes and behaviors
      //Class is a description of an object, a blueprint
      //Card
      //5.2 Constructors
      String name = new String("Bob Mould");
      Card card = new Card("K", "S", 10);
      Card card2 = new Card("Q", "H", 11);
      
      //5.3 Document your code with comments
      //5.4 Accessor Methods- allows you to get a value from an object - Getters
      System.out.println(card.getName());
      System.out.println(card.getSuit());
      System.out.println(card.getValue() + "\n");
      System.out.println(card2.getName() + " " + card2.getSuit() + " " + card2.getValue());
      
      //5.5 Mutator Methods - Setters
      // Dont do this:card.suit = "D"; 
      card.setName("A");
      card.setSuit("S");
      card.setValue(1);
      
      System.out.println(card);
      // 5.6 Writing Methods
      card.printCard();
      
      // 5.7 Static Method: Not attached to objects of class, is attached to class itself
      //Lets us make functions that aren't attached to an object
      Card.printCard("A", "S");
      Card.printCard("J", "H");
      
      // 5.8 Scope and access
    // Doesn't work because name is private, you have to use an accessor method. System.out.println(card.name);
    System.out.println(card.getName());
    //Access = What can be accessed
    //Scope ~ where something exists.
    //System.out.println("x: " +card.x);
    
    }
} 
