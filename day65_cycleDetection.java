import java.util.*;

public class day65_cycleDetection {

    static ArrayList<ArrayList<Integer>> graph;

    static boolean dfs(int node, int parent, boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // If neighbor is not visited
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited)) {
                    return true;
                }
            }

            // Already visited and not the parent
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges:");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // Undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        boolean cycle = false;

        // Check all components
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                if (dfs(i, -1, visited)) {
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