package _813_Stack_Of_Boxes;

import java.util.LinkedList;
import java.util.List;

public class TesterClass {

    public static void main(String[] args) {

        List<Box> boxes = new LinkedList();
        boxes.add(new Box(4, 6, 3));
        boxes.add(new Box(3, 5, 1));
        boxes.add(new Box(7, 9, 3));
        boxes.add(new Box(5, 4, 6));
        System.out.println("Input boxes : " + boxes + "\n");
        System.out.println("Max height : " + StackOfBoxes.findBoxesMaxHeight(boxes));
    }

}
