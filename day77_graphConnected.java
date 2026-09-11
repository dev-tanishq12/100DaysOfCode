import java.util.*;

public class day77_graphConnected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges
        
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1; // convert to 0-based
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        // run DFS from node 0
        dfs(graph, visited, 0);
        
        // check if all nodes visited
        boolean connected = true;
        for (boolean v : visited) {
            if (!v) {
                connected = false;
                break;
            }
        }
        
        if (connected) {
            System.out.println("CONNECTED");
        } else {
            System.out.println("NOT CONNECTED");
        }
    }
    
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
