public class ConstructorsOfHumanClass {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String address;
        private int age;
        private int weight;
        private int height;
        private boolean money;

        public Human (String name) {
            this.name = name;
        }

        public Human (String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human (String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human (String name, boolean money) {
            this.name = name;
            this.money = money;
        }

        public Human (String name, boolean money, String address) {
            this.name = name;
            this.money = money;
            this.address = address;
        }

        public Human (String name, boolean money, int age) {
            this.name = name;
            this.money = money;
            this.age = age;
        }

        public Human (int age, String name) {

            this.age = age;
            this.name = name;
        }

        public Human (boolean money, String name) {
            this.money = money;
            this.name = name;
        }

        public Human (boolean money, int age, String name) {
            this.money = money;
            this.age = age;
            this.name = name;
        }
    }
}
