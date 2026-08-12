// Height of Binary Tree = DFS (Depth First Search) = find the longest path from root to leaf node

import java.util.*;

public class day47_HeightBtree {

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

    // DFS to find height
    static int maxDepth(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // DFS on left and right
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Return maximum height
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter level order elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = buildTree(arr);
    
        int height = maxDepth(root);

        System.out.println("Height of Binary Tree: " + height);

        sc.close();
    }
}