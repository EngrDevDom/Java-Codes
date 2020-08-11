public class ArrayWorkExceptions {
    public static void main(String[] args) {
        //напишите тут ваш код

        int[] m = new int[2];


        //напишите тут ваш код
        try
        {
            m[8] = 5;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }
}
