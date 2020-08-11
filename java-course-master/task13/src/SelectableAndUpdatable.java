public class SelectableAndUpdatable {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh();
    }

    //напишите тут ваш класс
    public class Screen implements Selectable, Updatable {
        @Override
        public void onSelect() {

        }

        @Override
        public void refresh() {

        }
    }
}
