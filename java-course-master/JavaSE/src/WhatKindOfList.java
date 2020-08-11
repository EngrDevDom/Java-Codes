import java.util.ArrayList;
import java.util.Collections;

public class WhatKindOfList {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "ma", "mam", "pa", "pap", "papa");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++)
        {
            //   int j = list.size() - i - 1;
            System.out.println( list.get(i) );
        }
    }
}
