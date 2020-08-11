public class ForLoopAndMore {
    public static void main(String[] args) {
        //4.2 For loop
        // Count up
        for (int i = 0; i<10; i++) {
            System.out.println("i: " + i);
        }
        // Count down
        System.out.println();
        for (int i = 10; i>0; i--) {
            System.out.println("i: " + i);
        }

        // Count down with decrement of 2
        System.out.println();
        for (int i = 10; i>0; i-=2) {
            System.out.println("i: " + i);
        }

        //4.3 Developing algorithms with strings
        String grades ="ABBCAAABCABBAAB";
        int aNum = 0;
        //Iterate through the string one at a time;
        System.out.println(grades);
        for(int i = 0; i<grades.length();i++) {
            //Compre each letter to A
            if(grades.substring(i, i+1).equals("A")){
                aNum++;
            }

        }
        System.out.println("Number of As: " +aNum);

        //4.4 Nested Iteration
        for(int a = 0; a<6;a++) {
            for(int b=0; b<6;b++) {
                System.out.println(a + " : " + b);
            }
        }
        //a and b are local to the for loop and are able to be used multiple times
        //4.5 Informal code analysis
        int iterationsNum = 0;
        for(int a = 0; a<10;a++) {
            iterationsNum++;
        }
        System.out.println("iterationsNum: "+iterationsNum + "\n");
        iterationsNum = 0;
        for(int a = 0; a<1000; a++) {
            for(int b = 0; b < 50000; b++){
                iterationsNum++;
            }
        }
        //Inner loop * outer loop
        System.out.println("iterationsNum: " + iterationsNum);
    }
}