public class Pets {
    public static void main(String[] args) {
    }

    public class Pet {
        String name;
        void voice() {
            System.out.println("Voice");
        }
    }

    public class Cat extends Pet {
        void voice() {
            System.out.println("Myau");
        }
    }

    public class Dog extends Pet {
        void voice() {
            System.out.println("Gav-gav");
        }
    }
}
