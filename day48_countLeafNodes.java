import java.util.*;
public class day48_countLeafNodes {

    // Node of Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Build tree from level order
    static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < arr.length) {

            Node current = queue.poll();

            // Left child
            if (arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Count leaf nodes
    static int countLeafNodes(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // If leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = countLeafNodes(root.left);
        int right = countLeafNodes(root.right);

        return left + right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the binary tree: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = buildTree(arr);
        int leafCount = countLeafNodes(root);
        System.out.println("Number of leaf nodes: " + leafCount);

        sc.close();
    }
}