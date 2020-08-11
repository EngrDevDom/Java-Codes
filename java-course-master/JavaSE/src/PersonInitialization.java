public class PersonInitialization {
    public static void main(String[] args) {
        //напишите тут ваш код
        Person person = new Person();
        person.initialize("Danila",42);

    }

    static class Person {
        //напишите тут ваш код
        public int age;
        public String name;

        public void initialize(String name, int age) {
            this.name = name;
            this.age = age;
        }
/*
        public void initialize(String name) {
            this.name = name;
        }

        public void initialize(int age) {
            this.age = age;
        }

 */
    }
}
