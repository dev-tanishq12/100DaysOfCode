import java.util.*;

public class day66_cycleDetectionDirected {

    static ArrayList<ArrayList<Integer>> graph;

    static boolean dfs(int node, boolean[] visited, boolean[] path) {

        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph.get(node)) {

            // If neighbor is not visited
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, path)) {
                    return true;
                }
            }

            // Neighbor is already in current DFS path
            else if (path[neighbor]) {
                return true;
            }
        }

        // Remove node from current DFS path
        path[node] = false;

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges:");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // Directed edge: u -> v
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];

        boolean cycle = false;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, visited, path)) {
                    cycle = true;
                    break;
                }
            }
        }

        if (cycle)
            System.out.println("YES");
        else
            System.out.println("NO");

        sc.close();
    }
}