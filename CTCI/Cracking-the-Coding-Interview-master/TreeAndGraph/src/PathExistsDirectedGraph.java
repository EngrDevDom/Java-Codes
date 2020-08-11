import java.util.Deque;
import java.util.LinkedList;

public class PathExistsDirectedGraph {

    static class Graph{
        int numberOfVertices;
        LinkedList adj[];

        Graph(int numberOfVertices){
            this.numberOfVertices = numberOfVertices;
            adj = new LinkedList[numberOfVertices];

            for(int i=0;i<numberOfVertices;i++){
                adj[i] = new LinkedList();
            }
        }
        public void addEdge(int a, int b){
            adj[a].add(b);
        }

        public boolean isReachable(int s, int d){
            Deque<Integer> queue = new LinkedList<>();
            boolean[] visitedArray = new boolean[numberOfVertices];

            queue.add(s);
            visitedArray[s] = true;

            while(!queue.isEmpty()) {
                s = queue.poll();
                for (int i = 0; i < adj[s].size(); i++) {
                    int temp = (int) adj[s].get(i);
                    if (temp == d) {
                        return true;
                    }
                    if(!visitedArray[temp]) {
                        visitedArray[temp] = true;
                        queue.add(temp);
                    }

                }
            }
            return false;
        }

        public static void main(String[] args) {
            Graph g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            int u = 1;
            int v = 3;
            if (g.isReachable(u, v))
                System.out.println("There is a path from " + u +" to " + v);
            else
                System.out.println("There is no path from " + u +" to " + v);;

            u = 3;
            v = 1;
            if (g.isReachable(u, v))
                System.out.println("There is a path from " + u +" to " + v);
            else
                System.out.println("There is no path from " + u +" to " + v);;

        }
    }
}
/*
Algorithm: BFS using adjacency list

1. Take a dequeue and push the starting node in it.
2. Take an array called visited and mark the value of that particular index(corresponding to that vertex) as true.
3. Iterate till the queue is not empty
    a) pop element from queue.
    b) Iterate through the adjacency list of the popped element
        i) If that element is equal to end point, return true.
        ii) if visited array does not have the element marked as true, add the element to queue and mark it as visited.
4. return false
 */
