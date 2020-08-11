public class GoodWorkers {
    public static void main(String[] args) {
    }

    public class Manager extends Employee {
        void work() {
            System.out.println("I can manage");
        }
    }

    public class Chief extends Employee {
        void work() {
            System.out.println("I can manage globally");
        }
    }

    public class Employee {
        String name;
        int age;
        int experience;
        void work() {
            System.out.println("I can work");
        }
    }

    public class Secretary extends Employee {
        void work() {
            System.out.println("I can write");
        }
    }
}
