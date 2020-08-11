package _401_Route_Between_Nodes;

import chapters.common.GraphNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RouteBetweenNodesExists {

    public static boolean routeBetweenNodesExists(GraphNode startNode, GraphNode endNode) {

        if (startNode == endNode) {
            return true;
        }

        //run Breadth First Search

        Deque<GraphNode> deque = new ArrayDeque<>();
        startNode.visit();
        deque.add(startNode);

        while (!deque.isEmpty()) {
            GraphNode currentNode = deque.remove();
            if (currentNode == endNode) {
                return true;
            }
            for (GraphNode gn : currentNode.getNeighbors()) {
                if (!gn.visited) {
                    gn.visit();
                    deque.add(gn);
                }
            }

        }
        return false;
    }

}
