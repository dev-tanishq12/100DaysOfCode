import java.util.Scanner;

public class day61_graphAdjacencyMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of vertices
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        // Read number of edges
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        // Create adjacency matrix
        int[][] matrix = new int[n][n];

        // Read all edges
        System.out.println("Enter the edges (u v):");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // Edge from u to v
            matrix[u][v] = 1;
        }

        // Print adjacency matrix
        System.out.println("\nAdjacency Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}