import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatsFamily {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String papaName = reader.readLine();
        Cat catPapa = new Cat(papaName, catGrandpa);

        String motherName = reader.readLine();
        Cat catMother = new Cat(catGrandma, motherName);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catPapa);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catPapa);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catPapa);
        System.out.println(catMother);
        System.out.println(catSon);
        // System.out.println("The cat's name is " + name + ", mother is " + parent1.name + " father is " + parent2.name);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent1, parent2;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent1) {
            this.name = name;
            this.parent1 = parent1;
        }

        Cat(Cat parent2, String name) {
            this.parent2 = parent2;
            this.name = name;

        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }

        @Override
        public String toString() {
            if (parent1 == null && parent2 == null)
                return "The cat's name is " + name + ", no mother, no father";

            else if (parent2 == null)
                return "The cat's name is " + name + ", no mother, father is " + parent1.name;

            else if (parent1 == null)
                return "The cat's name is " + name + ", mother is " + parent2.name + " no father";

            else if (name == "Мурчик")
                return "The cat's name is " + name + ", mother is " + parent1.name + " father is " + parent2.name;
            else
                return "The cat's name is " + name + ", mother is " + parent1.name + " father is " + parent2.name;
        }
    }

}
