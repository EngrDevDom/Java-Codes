package _407_Project_Build_Order;

import java.util.ArrayList;

public class Node {

    public String value;
    public ArrayList<Node> neighbors;
    public Visited status;


    public Node(String value) {
        this.value = value;
        neighbors = new ArrayList();
        status = Visited.NEW;

    }

    public void addDirectedNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public enum Visited {
        NEW, ACTIVE, DONE;
    }
}
