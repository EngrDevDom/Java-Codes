public class MultiplicationTable {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 1;
        int j = 1;
        while (i <= 10) {
            while (j <= 10) {
                System.out.print(j*i + " ");
//                System.out.print(String.format("%4d", j*i));
                j++;
            }
            System.out.println();
            i ++;
            j = 1;
        }
    }
}
