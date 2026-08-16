import java.util.*;
public class day51_LCA_BST {
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

    // Insert into BST
    static Node insert(Node root, int value) {

        // If tree is empty
        if (root == null) {
            return new Node(value);
        }

        // Smaller value goes left
        if (value < root.data) {
            root.left = insert(root.left, value);
        }

        // Larger value goes right
        else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Find LCA in BST
    static Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (n1 < root.data && n2 < root.data) {
            return findLCA(root.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (n1 > root.data && n2 > root.data) {
            return findLCA(root.right, n1, n2);
        }

        // Otherwise, the current node is the LCA
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        // Insert nodes into BST
        System.out.println("Enter number of nodes to insert:");
        int n = sc.nextInt();
        System.out.println("Enter the values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        // Find LCA
        System.out.println("Enter two nodes to find their LCA:");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        Node lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println(lca.data);
        } else {
            System.out.println("LCA not found.");
        }

        sc.close();
    }
}
