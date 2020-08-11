import java.util.Stack;

public class HanoiTowers {
    public static void main(String[] args) {
        int n = 3;
        Tower[] tower = new Tower[n];

        for(int i = 0; i<n; i++){
            tower[i] = new Tower(i);
        }

        for(int i = n-1; i>=0; i--){
            tower[0].add(i);
        }
        tower[0].print();
        tower[2].print();
        tower[0].moveDisks(n,tower[2],tower[1]);  
        tower[2].print();
    }
}

/**
 * InnerHanoiTowers
 * OUTPUT : Contents of Tower 0: [2, 1, 0]
 *          Contents of Tower 2: []
 *          Contents of Tower 2: [2, 1, 0]
 */
class Tower {
    private Stack<Integer> disks;
    private int index;
    
    Tower(int i){
        disks = new Stack<Integer>();
        index = i;
    }

    int index(){
        return index;
    }

    void add(int d){
        if(!disks.isEmpty() && disks.peek() <= d){
            System.out.println("Error placing disk "+d);
        }else{
            disks.push(d);
        }
    }

    public void print() {
		System.out.println("Contents of Tower " + index + ": " + disks.toString());
	}

    void moveTopTo(Tower t){
        int top = disks.pop();
        t.add(top);
    }

    void moveDisks(int n, Tower destination, Tower buffer){
        if(n>0){
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

}   