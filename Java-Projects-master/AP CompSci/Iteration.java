public class Iteration {
    public static void main(String[] args) {
        //4.1 While loop
        //Infinite loop
        /*int i = 0;
         *while(true){
         *  i++;
         *   System.out.println("Line Number: " + i +" Infinite Loop");
         *}
         */
        //Finite loop
        int x = 0;
        while(x<10)
        {
            System.out.println("x: " + x);
            x++;
        }
        System.out.println();
        x = 0;
        while(x<10)
        {
            x++;
            System.out.println("x: " + x);

        }
        System.out.println();
        x = 0;
        while(x<=10)
        {
            x++;
            System.out.println("x: " + x);

        }
        System.out.println();
        x = 0;
        while(x<=10)
        {

            System.out.println("x: " + x);
            x++;
        }
        System.out.println();
        x = 10;
        while(x>0)
        {

            System.out.println("x: " + x);
            x--;
        }
        System.out.println();

    }
}