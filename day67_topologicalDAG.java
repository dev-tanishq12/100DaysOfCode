// Print topological ordering of a Directed Acyclic Graph (DAG) using DFS.

import java.util.*;
import java.util.Stack;

public class day67_topologicalDAG {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Stack<Integer> stack;

    static void dfs(int node) {

        visited[node] = true;

        // Visit all neighbours
        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

        // Add after visiting all neighbours
        stack.push(node);
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

        visited = new boolean[vertices];
        stack = new Stack<>();

        // DFS for every vertex
        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {
                dfs(i);
            }
        }

        // Print topological order
        System.out.println("Topological Order:");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}