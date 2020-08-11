package _407_Project_Build_Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public List<Node> nodes = new ArrayList();
    public Map<String, Node> nodesMap = new HashMap();

    public void addNode(String source) {
        Node node = new Node(source);
        nodes.add(node);
        nodesMap.put(source, node);
    }

    public void addDirectedEdge(String source, String destination) {
        Node sourceNode = nodesMap.get(source);
        Node destinationNode = nodesMap.get(destination);
        sourceNode.addDirectedNeighbor(destinationNode);
    }


}
