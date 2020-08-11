public class ThreeInOne {

    // Fixed division - same size of all the 3 stacks
    static class FixedMultiStack {
        int stackCapacity;
        int numberOfStack = 3;
        int[] values;
        int[] sizes;

        FixedMultiStack(int stackCapacity) {
            this.stackCapacity = stackCapacity;
            values = new int[numberOfStack * stackCapacity];
            sizes = new int[numberOfStack];
        }

        public void push(int stackNum, int data){
            if(isFull(stackNum)){
                System.out.println("Stack full, cannot push further");
            }
            int index = indexOfTop(stackNum);
            index++;
            values[index] = data;
            sizes[stackNum]++;
        }

        public int pop(int stackNum){
            if(isEmpty(stackNum)){
                System.out.println("Stack empty, cannot pop further");
            }
            int index = indexOfTop(stackNum);
            sizes[stackNum]--;
            int item = values[index];
            values[index] = 0; //clear the value
            return item;
        }

        public int peek(int stackNum){
            int index = indexOfTop(stackNum);
            return values[index];
        }

        public boolean isEmpty(int stackNum) {
            return (sizes[stackNum] == 0);
        }

        public boolean isFull(int stackNum){
            return sizes[stackNum] == stackCapacity;
        }

        public int indexOfTop(int stackNum){
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset+size-1;
        }
    }

    public static void main(String[] args) {
        FixedMultiStack fs = new FixedMultiStack(5);
        System.out.println(fs.isEmpty(0));
        fs.push(0,1);
        fs.push(0,2);
        fs.push(1,2);
        fs.push(1,4);
        fs.push(2,1);
        fs.push(2,3);

        //System.out.println(fs.peek(0));
        //System.out.println(fs.peek(1));
        //System.out.println(fs.peek(2));

        System.out.println(fs.pop(2));
        System.out.println(fs.peek(2));
        fs.push(2,10);
        System.out.println(fs.peek(2));

    }
}
