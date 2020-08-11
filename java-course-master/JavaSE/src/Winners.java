import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Winners {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код

        //Arrays.sort(array, Collections.reverseOrder());
        //Collections.reverse(Ints.asList(intArr));
        //    Arrays.sort(new int[][]{array}, Collections.reverseOrder());
        //      Collections.sort(array);
//        Collections.reverse(array);
//        Arrays.sort(array,19, 0);
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++)
            list.add(array[i]);

        // for (int i : array)
        //   list.add(array[i]);
        Collections.sort(list);
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);



        //   int max = array.length-1;

        // reversing the order with a simple for-loop
        //System.out.println("Array in descending order:");
        // for(int i=max; i>=0; i--) {
        //     System.out.println(integerList[i]);
        //}
/*
        int max = array[0];

        for (int i = 0; i < 20; i ++) {
            for (int k = i+1; k < 20; k ++) {
                if (array[i] < array[k]) {
                    max = array[i];
                    array[i] = array[k];
                    array[k] = max;
                }
            }
        }

 */
    }
}
