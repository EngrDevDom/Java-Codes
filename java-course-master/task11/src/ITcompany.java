public class ITcompany {
    public static void main(String[] args) {
    }

    public class Worker {
        String name;
        int age;
        int experience;
        void work() {
            System.out.println("I can work");
        }
    }

    public class Clerk extends Worker {
        void service() {
            System.out.println("I can service");
        }
    }

    public class IT extends Worker {
        void intellect() {
            System.out.println("I can think");
        }
    }

    public class Programmer extends IT {
        //@Override
        void intellect() {
            System.out.println("I can programming");
        }
    }

    public class ProjectManager extends IT {
        void intellect() {
            System.out.println("I can manage a project");
        }
    }

    public class CTO extends IT {
        void intellect() {
            System.out.println("I can manage an IT-department");
        }
    }

    public class OfficeManager extends Clerk {
        void service() {
            System.out.println("I can manage an office");
        }
    }

    public class HR extends Clerk {
        void service() {
            System.out.println("I can advertising");
        }
    }

    public class Cleaner extends Clerk {
        void service() {
            System.out.println("I can clean");
        }
    }
}
