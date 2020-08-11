import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BodyMassControl {
    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
            // напишите тут ваш код
            double imt;
            imt = weight / (height * height);
            //System.out.println(imt);
            if (imt < 18.5)
                System.out.println("Недовес: меньше чем 18.5");
            else if (imt < 25.)
                System.out.println("Нормальный: между 18.5 и 25");
            else if (imt < 30.)
                System.out.println("Избыточный вес: между 25 и 30");
            else if (imt >= 30.)
                System.out.println("Ожирение: 30 или больше");
        }
    }
}
