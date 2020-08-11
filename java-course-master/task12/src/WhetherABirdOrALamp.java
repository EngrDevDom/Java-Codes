public class WhetherABirdOrALamp {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение

        switch (o.getClass().getSimpleName()) {
            case ("Cat"):
                System.out.println("Кошка");
                break;
            case ("Bird"):
                System.out.println("Птица");
                break;
            case ("Lamp"):
                System.out.println("Лампа");
                break;
            case ("Dog"):
                System.out.println("Собака");
                break;
            default:
                System.out.println(o.getClass().getSimpleName());
                break;
        }

    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
