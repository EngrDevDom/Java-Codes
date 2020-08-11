package chapters.common;

import java.util.ArrayList;

public class GraphNode {

    public int value;
    public boolean visited;
    private ArrayList<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
        this.visited = false;
        this.neighbors = new ArrayList();
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
        neighbor.neighbors.add(this);
    }

    public void visit() {
        this.visited = true;
    }

    public void addDirectedNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }
}
