// Check whether a given binary tree satisfies the Min-Heap property.

public class day60_validate_MinHeap {

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

    static boolean isMinHeap(Node root) {

        // An empty tree is a Min-Heap
        if (root == null) {
            return true;
        }

        // Check if the current node satisfies the Min-Heap property
        if ((root.left != null && root.data > root.left.data) ||
                (root.right != null && root.data > root.right.data)) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isMinHeap(root.left) && isMinHeap(root.right);
    }

    public static void main(String[] args) {

        // Construct a binary tree
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(9);
        root.right.left = new Node(8);
        root.right.right = new Node(10);

        // Check if the binary tree satisfies the Min-Heap property
        if (isMinHeap(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}