import java.util.*;

public class day62_graphAdjacencyList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create an empty list for every vertex
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // Add v to u's list
            adj.get(u).add(v);

            // If graph is undirected, also add u to v's list
            adj.get(v).add(u);
        }

        // Print adjacency list
        System.out.println("\nAdjacency List:");

        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");

            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}