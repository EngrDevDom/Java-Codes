public class CatsAndDogs {
    public static void main(String[] args) {
        // напишите тут ваш код
        for (int i = 0; i < 50000; i ++) {
            new Cat();
            new Dog();
        }
    }
}
class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("A Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("A Dog was destroyed");
    }
}
