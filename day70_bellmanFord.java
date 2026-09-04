import java.util.*;

public class day70_bellmanFord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int[][] edges = new int[E][3];

        System.out.println("Enter edges (source destination weight):");

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt(); // source
            edges[i][1] = sc.nextInt(); // destination
            edges[i][2] = sc.nextInt(); // weight
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        int[] dist = new int[V];

        // Initially all distances are infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance from source to itself = 0
        dist[source] = 0;

        // Step 1: Relax all edges V-1 times
        for (int i = 1; i < V; i++) {

            for (int j = 0; j < E; j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Step 2: Check for negative cycle
        boolean negativeCycle = false;

        for (int j = 0; j < E; j++) {

            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + weight < dist[v]) {

                negativeCycle = true;
                break;
            }
        }

        // Output
        if (negativeCycle) {

            System.out.println("Negative weight cycle exists.");

        } else {

            System.out.println("Shortest distances:");

            for (int i = 0; i < V; i++) {

                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println(i + " = INF");
                } else {
                    System.out.println(i + " = " + dist[i]);
                }
            }
        }

        sc.close();
    }
}