import java.util.*;

public class day53_Btree_vertical {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Store node and its column
    static class Pair {
        Node node;
        int column;

        Pair(Node node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    // Vertical order traversal
    static void verticalOrder(Node root) {

        if (root == null) {
            return;
        }

        // TreeMap keeps columns sorted
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        // Queue for BFS
        Queue<Pair> queue = new LinkedList<>();

        // Root is at column 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            Node node = current.node;
            int column = current.column;

            // Add node to its column
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }

            map.get(column).add(node.data);

            // Left child -> column - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, column - 1));
            }

            // Right child -> column + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, column + 1));
            }
        }

        // Print from leftmost column to rightmost column
        for (ArrayList<Integer> list : map.values()) {

            for (int value : list) {
                System.out.print(value + " ");
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Vertical Order: ");
        verticalOrder(root);
    }
}