import java.util.LinkedList;
abstract class Animal{
    private int order;
    protected String name;
    public abstract String name();
    public Animal(String n){
        name = n;
    }
    public void setOrder(int ord){
        order = ord;
    }
    public int getOrder() {
        return order;
    }
    public boolean isOlder(Animal a){
        return this.order < a.getOrder();
    }
}
class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;                          //timestamp

    public void enQueue(Animal a){
        a.setOrder(order);
        order++;

        if(a instanceof Dog){
            dogs.addLast((Dog)a);
        }
        else if(a instanceof Cat){
            cats.addLast((Cat)a);
        }
    }

    public Animal deQueueAny(){
        //looks at the tops of dogs n cats, pop the queue with oldest value
        if(dogs.size() == 0){
            return dequeueCats();
        }
        else if(cats.size() == 0){
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlder(cat)){
            return dequeueDogs();
        }else{
            return dequeueCats();
        }
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }
    public Cat dequeueCats(){
        return cats.poll();
    }
}

class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
    
    public String name() {
        return "Dog: " + name;
    }
}

class Cat extends Animal{
    public Cat(String n) {
        super(n);
    }
    
    public String name() {
        return "Cat: " + name;
    }
}