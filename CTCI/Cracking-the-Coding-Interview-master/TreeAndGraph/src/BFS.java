import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    static class Graph{
        private int numberOfVertices;
        private LinkedList adj[];

        Graph(int numberOfVertices){
            this.numberOfVertices = numberOfVertices;
            adj = new LinkedList[numberOfVertices];
            for(int i=0;i<numberOfVertices;i++){
                adj[i] = new LinkedList();
            }
        }

        public void addEdge(int start, int end){
            adj[start].add(end);
        }

        public void print(){
            for(int i=0;i<adj.length;i++){
                System.out.print(i+" -> ");
                for(int j=0;j<adj[i].size();j++){
                    System.out.print(adj[i].get(j)+" ");
                }
                System.out.println();
            }
        }

        public void bfs(int s){
            boolean visited[] = new boolean[numberOfVertices];
            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[s] = true;
            queue.add(s);
            while(queue.size() !=0 ){
                s = queue.poll();
                System.out.println(s);
                Iterator it = adj[s].iterator();
                while(it.hasNext()){
                    int t = (int)it.next();
                    if(!visited[t]){
                        visited[t] = true;
                        queue.add(t);
                    }
                }
            }

        }

        public static void main(String[] args) {
            Graph g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Adjacency list of the graph:");
            g.print();

            System.out.println("BFS traversal:");
            g.bfs(2);
        }
    }
}
/*

https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/


Queue - poll
The poll() method of Queue Interface returns and removes the element at the front the container.
It deletes the element in the container. The method does not throws an exception when the Queue is empty, it returns null instead.
 */