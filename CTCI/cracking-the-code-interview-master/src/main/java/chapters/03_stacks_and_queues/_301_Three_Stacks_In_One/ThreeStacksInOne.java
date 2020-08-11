package _301_Three_Stacks_In_One;

public class ThreeStacksInOne {

    private final int numberOfStacks = 3;
    private final int stackSize = 100;
    private int[] stackArray = new int[stackSize * numberOfStacks];
    //array that holds the number of elements in each stack
    private int[] stackHeads = { -1, -1, -1 };

 

    public int pop(int stackNumberber) throws Exception {
        if (stackHeads[stackNumberber] == -1) {
            throw new Exception("No element to pop");
        }
        int offset = arrayOffSet(stackNumberber) + stackHeads[stackNumberber];
        stackHeads[stackNumberber]--;
        return stackArray[offset];
    }

    public int peek(int stackNumber) throws Exception {
        if (stackHeads[stackNumber] == -1) {
            throw new Exception("No element to pop");
        }
        int offset = arrayOffSet(stackNumber) + stackHeads[stackNumber];
        return stackArray[offset];
    }

    public void push(int value, int stackNumber) throws Exception {
        if (stackNumber < 0 || stackNumber >= numberOfStacks) {
            throw new Exception("Stack number out of range");
        }
        if (stackHeads[stackNumber] >= stackSize) {
            throw new Exception("Out of space");
        }
        stackHeads[stackNumber]++;
        int offSet = arrayOffSet(stackNumber) + stackHeads[stackNumber];
        stackArray[offSet] = value;
    }

    public boolean isEmpty(int stackNumber) {
        return (stackHeads[stackNumber] == -1);
    }

    private int arrayOffSet(int stackNumber) {
        return stackSize * stackNumber;
    }

    public void printStacks() {
        for (int stackNumber = 0; stackNumber <= 2; stackNumber++) {
            System.out.print("\nStack #" + stackNumber + ": ");
            for (int i = arrayOffSet(stackNumber); i <= arrayOffSet(stackNumber) + stackHeads[stackNumber]; i++) {
                System.out.print(stackArray[i] + " ");
            }
        }
    }
}
