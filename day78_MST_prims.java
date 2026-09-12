import java.util.*;

public class day78_MST_prims {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // Hardcoded input
        int n = 4;
        int m = 5;
        int[][] edges = {
            {1, 2, 3},
            {1, 3, 5},
            {2, 3, 1},
            {2, 4, 4},
            {3, 4, 2}
        };

        // Build adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1, w = e[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        System.out.println("Total weight of MST = " + primMST(graph, n));
    }

    public static int primMST(List<List<Edge>> graph, int n) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Start from node 0
        visited[0] = true;
        pq.addAll(graph.get(0));

        int totalWeight = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n - 1) {
            Edge e = pq.poll();
            if (visited[e.to]) continue;

            visited[e.to] = true;
            totalWeight += e.weight;
            edgesUsed++;

            for (Edge next : graph.get(e.to)) {
                if (!visited[next.to]) pq.add(next);
            }
        }

        return totalWeight;
    }
}
