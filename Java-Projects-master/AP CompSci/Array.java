public class Array {
    public static void main(String[] args) {
        //6.1 Array Creation and Access
        int[] scores = new int[8];

        String name = "Michael";
        for(char letter: name.toCharArray()) {
            System.out.println(letter); 
        }
        // Assigning values
        scores[0] = 100;
        scores[1] = 90;
        scores[2] = 74;
        scores[3] = 24;
        scores[4] = 68;
        scores[5] = 20;
        scores[6] = 95;
        scores[7] = 91;
        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[0] + scores[1]);
        //Array of Strings
        //String[] args == Array of string arguments
        String[] names = new String[7];
        names[0] = "Jeff";
        names[1] ="Jenn";
        names[2] = "Dan";
        names[3] = "Fred";
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        System.out.println(names[3]);

        // Array initializer list
        String[] cities ={"Wildwood", "Chicago", "Dallas"};
        System.out.println(cities[0]);
        System.out.println(cities[1]);
        names[2] = "Daniel";
        System.out.println(cities[2] + "\n");
        //Array length
        System.out.println(cities.length);
        //No parentheses
        //6.2 Traversing arrays
        for(int i = 0; i<scores.length; i++) {
            System.out.println(scores[i]);
        }
        System.out.println();

        for(int i = 0; i<names.length; i++) {
            System.out.println(names[i]);
        }
        System.out.println();
        int f = 0;
        while(f<cities.length) {

            System.out.println(cities[f]);
            f++;
        }
        System.out.println();        
        for(int i =names.length-1;i>=0; i--) {
            System.out.println(names[i]);
        }
        System.out.println();

        //6.3 enhanced for loop: iterate through a loop without an index. For each thing in array do something
        for(int score: scores) {
            System.out.println(score);   
        }
        System.out.println();

        for(String city: cities) {
            System.out.println(city);
        }

        //6.4 Standard algorithms

        //Determining a max or min value
        int[] avgs = {34, 43,13, 57, 68, 21, 23, 78, 98, 93};
        int max = avgs[0];
        for(int i = 1; i <avgs.length; i++) {
            if(avgs[i] > max){
                max = avgs[i];
            }
        }
        System.out.println("The max is " +max);

        //Compute sum or average
        double[] prices = {4.22, 43.99, 2.00, 3.53, 12.54, .45, 15.44, 49.9, 40.00};
        double sum = 0.0;
        double average = 0.0;
        for(double price: prices){
            sum +=price;
        }
        System.out.println(sum);
        average = sum/prices.length;
        System.out.println(average);
        System.out.println();

        //Determine if element has a property
        boolean isOverFifty = false;
        for(double price: prices) {
            if(price > 49.99) {
                isOverFifty = true;   
            }
        }
        if(isOverFifty)
        {
            System.out.println("There is an item over 49.99");
        }
        else {
            System.out.println("Nothing is over 50");
        }
        System.out.println(isOverFifty);

        //Determine if all elements have a property
        boolean isUnderFifty = true;
        for(double price: prices) {
            if(price>=49.99) {
                isUnderFifty = false;
            }            
        }
        if(isUnderFifty) {
            System.out.println("All Items are under 50");
        }
        else {
            System.out.println("All items aren't under 50");
        }

        //Access all consecutive pairs of elements
        String[] foods = {"Apple", "Strawberry", "Ham", "Orange", "Banana"};
        for(int i =0; i<foods.length-1; i++) {
            System.out.println(foods[i] + " " + foods[i+1]);
        }
        for(int i =0; i<foods.length-2; i++) {
            System.out.println(foods[i] + " " + foods[i+2]);
        }
        System.out.println();

        //Determine the presence or absence of duplicate elements
        String[] superheroes = {"Batman", "Thor", "Iron Man", "Thor", "Super Man", "Spider Man"};
        boolean areDuplicates = false;
        for(int i = 0;i<superheroes.length; i++) {
            for(int x = i+1; x<superheroes.length; x++) {
                if(superheroes[i].equals(superheroes[x])){
                    areDuplicates = true;
                    break;
                }
            }
        }
        System.out.println("Are there duplicates?\n" + areDuplicates);

        //Determine number of elements that meet a certain criteria
        String genders[] = {"M", "F", "F", "M" ,"M", "F", "F", "F", "M"};
        int femaleNum=0;
        for(int i = 0; i<genders.length;i++) {
            if(genders[i].equals("F")) {
                femaleNum++;   
            }
        }                
        System.out.println("femaleNum: " +femaleNum);

        //Shifting array elements left. A similar patter used for right shift
        String[] letters = {"B", "A", "L", "L"};
        String tempLetter = letters[0];
        for(int i = 1;i<letters.length;i++){
            letters[i-1] = letters[i];   
        }
        letters[letters.length-1] = tempLetter;
        for(String letter: letters) {
            System.out.print(letter + ", ");   
        }
        System.out.println();

        //Reverse the order of elements
        String[] sNames={"Michael", "Jacob", "Gavin", "Ben", "Diego", "Steve", "Jake"};
        String tempSName;
        for(int i=0; i<sNames.length/2; i++) {
            tempSName = sNames[i];
            sNames[i] = sNames[sNames.length-i-1];
            sNames[sNames.length-i-1] = tempSName;         
        }
        for(String sName: sNames) {
            System.out.print(sName + ", ");
        }

    }
}










