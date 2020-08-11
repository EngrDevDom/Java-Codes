package _813_Stack_Of_Boxes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stack of Boxes: You have a stack of n boxes, with widths wt , heights h,, and depths dr The boxes
 * cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
 * larger than the box above it in width, height, and depth. Implement a method to compute the
 * height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
 */

public class StackOfBoxes {

    public static int findBoxesMaxHeight(List<Box> boxes) {
        if (boxes == null || boxes.size() == 0) {
            return 0;
        }
        boxes.sort((box1, box2) -> box2.getHeight() - box1.getHeight());
        Map<Integer, Integer> cacheMap = new HashMap<>();
        return findBoxesMaxHeight(boxes, -1, cacheMap);
    }

    private static int findBoxesMaxHeight(List<Box> boxes, int bottomBoxIndex, Map<Integer, Integer> cacheMap) {
        if (cacheMap.containsKey(bottomBoxIndex)) {
            return cacheMap.get(bottomBoxIndex);
        }

        int maxHeight = 0;
        Box bottomBox = bottomBoxIndex == -1 ? null : boxes.get(bottomBoxIndex);

        for (int i = bottomBoxIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).boxCanBeAbove(bottomBox)) {
                int height = findBoxesMaxHeight(boxes, i, cacheMap);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        maxHeight += bottomBoxIndex == -1 ? 0 : bottomBox.getHeight();
        cacheMap.put(bottomBoxIndex, maxHeight);
        return maxHeight;
    }
}
