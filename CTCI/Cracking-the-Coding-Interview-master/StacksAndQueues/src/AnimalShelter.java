import java.util.LinkedList;

public class AnimalShelter {

    //ANIMAL class
    abstract class Animal{
        int order;
        String name;

        Animal(String name){
            this.name = name;
        }

        void setOrder(int order){
            this.order = order;
        }

        int getOrder(){
            return order;
        }

        boolean isOlderThan(Animal a){
            return this.order < a.order;
        }
    }

    // ANIMAL QUEUE class
    static class AnimalQueue{
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;

        public void enqueue(Animal a){
            a.setOrder(order);
            order ++;
            if(a instanceof Dog){
                dogs.addLast((Dog) a);
            }else if(a instanceof Cat){
                cats.addLast((Cat)a);
            }
        }

        public Animal dequeuAny(){
            if(dogs.size() == 0){
                return dequeueCats();
            }else if(cats.size() == 0){
                return dequeueDogs();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();

            if(dog.isOlderThan(cat)){
                return dequeueDogs();
            }else {
                return dequeueCats();
            }
        }

        public Animal dequeueCats(){
            return cats.poll();
        }

        public Animal dequeueDogs(){
            return dogs.poll();
        }
    }

    class Dog extends Animal{
        Dog(String name){
            super(name);
        }
    }

    class Cat extends Animal{
        Cat(String name){
            super(name);
        }
    }
}

