import java.util.*;

public class day49_insertBST {

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

    // Inorder traversal
    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Node root = null;

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        System.out.print("Inorder traversal: ");
        inorder(root);

        sc.close();
    }
}