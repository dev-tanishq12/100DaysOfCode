import java.util.*;

public class day64_BFS {

    static int vertices;
    static ArrayList<ArrayList<Integer>> graph;

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    static void bfs(int start) {

        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        vertices = 5;

        graph = new ArrayList<>();

        // Create adjacency lists
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 4);

        bfs(0);
    }
}