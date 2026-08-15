import java.util.*;

public class day50_BSTsearch {

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

    // Search in BST
    static boolean search(Node root, int key) {

        // Base case: if the tree is empty or we found the key
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }

        // If the key is smaller than the root's data, search in the left subtree
        if (key < root.data) {
            return search(root.left, key);
        }
        
        // If the key is larger than the root's data, search in the right subtree
        return search(root.right, key);
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

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        if (search(root, key)) {
            System.out.println(key + " is present in the BST.");
        } else {
            System.out.println(key + " is not present in the BST.");
        }
        sc.close();
    }

}