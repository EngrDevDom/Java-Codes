public class UknownAnimal {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        switch (o.getClass().getSimpleName()) {
            case ("Cat"):
                return "Кот";

            case ("Tiger"):
                return "Тигр";

            case ("Whale"):
                return "Кит";

            case ("Lion"):
                return "Лев";

            case ("Bull"):
                return "Бык";

            default:
                return "Животное";

        }
        //return "Животное";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
