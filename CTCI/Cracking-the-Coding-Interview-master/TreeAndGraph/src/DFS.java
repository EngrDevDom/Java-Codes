import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    static class Graph{
        // number of vertices
        public int numberOfVertices;
        // adjacency list
        public LinkedList adj[];

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
                System.out.print(i+ " -> ");
                for(int j=0;j<adj[i].size();j++){
                    System.out.print(adj[i].get(j)+" ");
                }
                System.out.println();
            }
        }

        public void dfsUtil(int vertex, boolean visited[]){
            visited[vertex] = true;
            System.out.println(vertex+" ");
            Iterator it = adj[vertex].iterator();
            while(it.hasNext()){
                int n = (int)it.next();
                if(visited[n] != true) {
                    dfsUtil(n, visited);
                }
            }

        }

        public void dfs(){
            boolean visited[] = new boolean[numberOfVertices];
            for(int i=0;i<numberOfVertices;i++){
                if(visited[i] != true) {
                    dfsUtil(i, visited);
                }
            }

        }

        public static void main(String[] args) {
            Graph g = new Graph(4);
            g.addEdge(0,1);
            g.addEdge(0,2);
            g.addEdge(1,2);
            g.addEdge(2,0);
            g.addEdge(2,3);
            g.addEdge(3,3);
            g.print();

            System.out.println("Depth first traversal: ");
            g.dfs();
        }
    }
}

/*
Reference : https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

Iterating through a linked list in java:
https://beginnersbook.com/2013/12/how-to-loop-linkedlist-in-java/

Iterator i = linkedlist.iterator();
while (i.hasNext()) {
	System.out.println(i.next());
}

i.next() gives the value, if you again do i.next, it will get the next value.
 */
