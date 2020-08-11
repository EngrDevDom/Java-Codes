public class Dog {
    //2.1 Classes, Class, and Class Constructors
    private String name = "";
    private int age=0;   
    //private: anywhere outside the class can't get to the variable directly
    Dog () {
        System.out.println("I am a dog."); // This method is the constructor
    }

    Dog(String myName){
        System.out.println("I am a dog.");
        name = myName;
        System.out.println("My name is " + name + ".");
    }

    //2.3 Calling a Void Method
    public void bark() {
        System.out.println(name + " barks...BARK!!!");   
        //A value is not returned
    }
    //2.4 calling a Void Method with Parameters 
   public void setName(String myName){
       name = myName;  
    }
    
    //2.5 Calling a non-void method
    public String getName() {
     return name;   
    }

}
