//Perform DFS starting from a given source vertex using recursion.
import java.util.*;
public class day63_DFS {

    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        // Mark the current vertex as visited
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
    public static void main(String[] args) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Create an empty list for every vertex
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        // Perform DFS starting from vertex 0
        boolean[] visited = new boolean[5];
        System.out.println("DFS starting from vertex 0:");
        dfs(0, adj, visited);
    }
}
