import java.util.*;

public class day68_topologicalSorting {

    static ArrayList<ArrayList<Integer>> graph;

    static void topologicalSort(int vertices) {

        int[] indegree = new int[vertices];

        // Calculate in-degree
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add vertices with 0 in-degree
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {

            int node = q.poll();

            System.out.print(node + " ");

            // Remove edges from this node
            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                // If in-degree becomes 0
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 6;

        graph = new ArrayList<>();

        // Create graph
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        System.out.println("Topological Order:");

        topologicalSort(vertices);
    }
}