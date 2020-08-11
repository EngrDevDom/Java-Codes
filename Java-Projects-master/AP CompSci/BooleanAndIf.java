public class BooleanAndIf {
    public static void main(String[] args) {
        //3.1 Boolean expressions
        int x = 8;
        int y = 1;
        System.out.println(x==y);

        x = 3;
        y = 3;
        System.out.println(x==y);

        x = 9;
        double d = 9.0;
        System.out.println(x==d);

        x = 4;
        y = 2;
        System.out.println(x + " == " + y +": "+(x==y));
        System.out.println(x + " != " + y +": "+(x!=y));
        System.out.println(x + " < " + y +": "+(x<y));
        System.out.println(x + " <= " + y +": "+(x<=y));
        System.out.println(x + " > " + y +": "+(x>y));
        System.out.println(x + " >= " + y +": "+(x>=y));

        //3.2 if Statements and Control FLow
        int age = 25;
        //if(age> 25){
        //    System.out.println("Wow, you are old");
        //}
        //if ( age<= 25) {
        //    System.out.println("You are young");
        //}

        // 3.3 if-else statements
        // if(age > 25) {
        //     System.out.println("You are old");
        //}
        // else {
        //    System.out.println("You are young");
        // }

        //3.3 else if statements
        if(age > 25) {
            System.out.println("You are old");
        }
        else if( age< 25 ){
            System.out.println("You are young");
        }
        else {
            System.out.println("You can be both");
        }

        // 3.5 Boolean Expressions
        double score = 70;
        if((score>= 90) &&(score <=100)) {
            System.out.println("You got an A.");
        }
        else if((score>= 80) &&(score <90)) {
            System.out.println("You got a B.");
        }
        else if((score>= 70) &&(score <80)) {
            System.out.println("You got a C.");
        }
        else if((score>= 60) &&(score <70)) {
            System.out.println("You got a D.");
        }
        else{
            System.out.println("You ******* failed.");
        }

        //Short circutied evaluation
        int customerAge = 43;
        boolean isDisabled = true;
        if((customerAge >=65) || isDisabled) {
            System.out.println("You get a 10% discount.");
        }

        //3.6 Equivalent Boolean Expressions
        boolean a = false;
        boolean b = true;
        System.out.println(!(a||b));
        System.out.println(!a&&!b);
        System.out.println(!(a&&b));
        System.out.println(!a || !b);
        
        //3.7 Comparing objects
        String name1 = "Michael";
        String name2 = "Michael";
        String name3 = "Nicole";
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name1==name2);
        System.out.println(name1);
        System.out.println(name3);
        System.out.println(name1==name3);
        String name5 = new String("Linda");
        String name6 = new String("Linda");
        //They are in different places in computers memory. Objects are different but the names are the same
        System.out.println(name5);
        System.out.println(name6);
        System.out.println(name5 ==name6);
        System.out.println(name5);
        System.out.println(name6+"\nComparing with.equals()");        
        System.out.println(name5.equals(name6));
        
        if(name5.equals(name6)) {
            System.out.println("The names are the same");
        }
        else {
            System.out.println("The names aren't the same");
        }
        
        

    }
}