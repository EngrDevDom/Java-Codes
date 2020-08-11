import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VowelsAndConsonants {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text, s1;
        ArrayList<Character> listCharVowels = new ArrayList<Character>(); //список для гласных
        ArrayList <Character> listCharNonVowels = new ArrayList <Character>();
        text = reader.readLine();

        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i ++) {
            if (isVowel(ch[i]))
                listCharVowels.add(ch[i]);

            else  if (ch[i] == ' ')
                continue;

            else
                listCharNonVowels.add(ch[i]);
        }

        for (char c : listCharVowels)//бежим по списку, в который положили гласные
            System.out.print(c + " "); //выводи гланые на экран, не забываем пробел между ними

        System.out.println(); // переводим курсов на другую строчку

        for (char c : listCharNonVowels) //бежим по списку согласных
            System.out.print(c + " "); //выводим на экран все остальные символы, через пробел

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}
