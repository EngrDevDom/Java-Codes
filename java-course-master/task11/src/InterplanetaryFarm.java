public class InterplanetaryFarm {
    public static void main(String[] args) {
    }

    public class Animal {
        String name;
        int weight;
        int age;
    }

    public class Cow extends Animal {
        void milk() {
            System.out.println("I can give milk");
        }
    }

    public class Pig extends Animal {
        void dirty () {
            System.out.println("I am dirty");
        }
    }

    public class Sheep extends Animal {
        void wool() {
            System.out.println("I can give a wool");
        }
    }

    public class Bull extends Animal {
        void meat() {
            System.out.println("I can give a meat");
        }
    }

    public class Goat extends Animal {
        void smilk() {
            System.out.println("I can give a special milk");
        }
    }
}
