import java.util.*;

public class day76_countConnected {
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
        int components = 0;
        
        // count components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                components++;
            }
        }
        
        System.out.println(components);
    }
    
    // DFS helper
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
