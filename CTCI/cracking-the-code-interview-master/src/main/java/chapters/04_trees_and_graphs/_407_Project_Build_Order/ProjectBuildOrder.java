package _407_Project_Build_Order;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 */
public class ProjectBuildOrder {



    public static Deque<Node> buildGraphFromDependencies(String[] projects, String[][] dependencies) throws Exception {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.addNode(project);
        }
        for (String[] dependency : dependencies) {
            String source = dependency[0];
            String destination = dependency[1];
            graph.addDirectedEdge(source, destination);
        }
        return topologicalSort(graph);
    }

    private static Deque<Node> topologicalSort(Graph graph) throws Exception {
        Node source = new Node("Source");
        for (Node node : graph.nodes) {
            source.addDirectedNeighbor(node);
        }

        Deque<Node> deque = new ArrayDeque();
        topologicalSortDFS(source, deque);
        deque.removeFirst();
        return deque;
    }

    private static void topologicalSortDFS(Node node, Deque<Node> deque) throws Exception {
        node.status = Node.Visited.ACTIVE;
        for (Node n : node.neighbors) {
            if (n.status == Node.Visited.NEW) {
                topologicalSortDFS(n, deque);
            } else if (n.status == Node.Visited.ACTIVE) {
                throw new Exception("Graph has a cycle!");
            }
        }
        node.status = Node.Visited.DONE;
        deque.addFirst(node);
    }
}
