package StringRotation.LinkedLists;

public class RunMain {
        public static void main(String[] args) {
            linkedList list = new linkedList();
            list.insert(23);
            list.insert(12);
            list.insert(12);
            list.insert(45);
            list.inserAtStart(0);
            list.insertAt(55, 1);
            

            list.show();
        }
}