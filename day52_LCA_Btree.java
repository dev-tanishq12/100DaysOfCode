import java.util.*;

public class day52_LCA_Btree {

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

    // Build tree from array (level order) 
    // this is only required for input purposes, not part of the LCA logic
    static Node buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node current = q.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Find LCA in general binary tree
    static Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        if (leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public static void main(String[] args) {
    // if input not required directly use the Node class to create tree
    /* Manually construct the tree from the example
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.left.left = new Node(7);
        root.left.right.right = new Node(4);

        Node lca = findLCA(root, 5, 1);
        System.out.println("LCA of 5 and 1: " + lca.data); */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes (including nulls): ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        System.out.println("Enter values level-order:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val == -1) {
                arr[i] = null;
            } else {
                arr[i] = val;
            }
        }
        Node root = buildTree(arr);
        System.out.print("Enter first node value: ");
        int n1 = sc.nextInt();
        System.out.print("Enter second node value: ");
        int n2 = sc.nextInt();

        Node lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.data);
        } else {
            System.out.println("LCA does not exist.");
        }

        sc.close();
    }
}
