public class day79_FloydWarshall {
    static final int INF = 1000000000; // A large value to represent "no edge"

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {
            {0, 5, -1, 10},
            {-1, 0, 3, -1},
            {-1, -1, 0, 1},
            {-1, -1, -1, 0}
        };

        // Replace -1 with INF for easier processing
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == -1 && i != j) {
                    dist[i][j] = INF;
                } else {
                    dist[i][j] = graph[i][j];
                }
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print shortest distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
