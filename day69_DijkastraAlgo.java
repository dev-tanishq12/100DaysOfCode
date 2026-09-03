import java.util.*;

public class day69_DijkastraAlgo {

    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static void dijkstra(int V, ArrayList<ArrayList<Edge>> graph, int source) {

        int[] distance = new int[V];

        // Initially all distances are infinity
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Distance of source = 0
        distance[source] = 0;
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int dist = current[1];

            // Check all neighbors
            for (Edge edge : graph.get(node)) {

                int neighbor = edge.node;
                int weight = edge.weight;

                // Relaxation
                if (dist + weight < distance[neighbor]) {

                    distance[neighbor] = dist + weight;

                    pq.add(new int[]{neighbor, distance[neighbor]});
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < V; i++) {
            System.out.println(
                "Distance from " + source + " to " + i +
                " = " + distance[i]
            );
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // u -> v, weight
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 2));

        graph.get(2).add(new Edge(1, 1));
        graph.get(2).add(new Edge(3, 5));

        graph.get(1).add(new Edge(3, 1));

        graph.get(3).add(new Edge(4, 3));

        dijkstra(V, graph, 0);
    }
}