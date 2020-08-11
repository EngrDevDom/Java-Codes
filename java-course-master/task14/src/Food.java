public class Food {
    public static void main(String[] args) {
        Food2 food = new Food2();
        Selectable selectable = new Food2();
        Food2 newFood = (Food2) selectable;

        foodMethods(food);
        selectableMethods(selectable);
    }

    public static void foodMethods(Food2 food) {
        //тут добавьте вызов методов для переменной food
        food.onSelect();
        food.onEat();
    }

    public static void selectableMethods(Selectable selectable) {
        //тут добавьте вызов методов для переменной selectable
        selectable.onSelect();
    }

    interface Selectable {
        void onSelect();
    }

    static class Food2 implements Selectable {
        public void onEat() {
            System.out.println("The food was eaten");
        }

        @Override
        public void onSelect() {
            System.out.println("The food was selected");
        }
    }
}
