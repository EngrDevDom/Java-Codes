package _401_Route_Between_Nodes;

import chapters.common.GraphNode;

public class TesterClass {

    public static void main(String[] args) {

        GraphNode graphNode1 = new GraphNode(5);
        GraphNode graphNode2 = new GraphNode(10);
        GraphNode graphNode3 = new GraphNode(4);
        GraphNode graphNode4 = new GraphNode(7);
        graphNode1.addNeighbor(graphNode2);
        graphNode2.addNeighbor(graphNode3);
        graphNode3.addNeighbor(graphNode4);
        System.out.println(" Route exists between nodes: " + RouteBetweenNodesExists.routeBetweenNodesExists(graphNode1, graphNode4));

    }
}
