//Construct a binary tree from given inorder and postorder traversal arrays.

public class day59_constructTree {

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

    static int postIndex;

    static Node buildTree(int[] inorder, int[] postorder, int inStart, int inEnd) {

        // No elements in this subtree
        if (inStart > inEnd) {
            return null;
        }

        // Last element of postorder is the root
        Node root = new Node(postorder[postIndex]);
        postIndex--;

        // Find root in inorder
        int index = inStart;

        while (inorder[index] != root.data) {
            index++;
        }

        // Build right subtree first
        root.right = buildTree(inorder, postorder, index + 1, inEnd);

        // Build left subtree
        root.left = buildTree(inorder, postorder, inStart, index - 1);

        return root;
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {4, 2, 5, 1, 3};
        int[] postorder = {4, 5, 2, 3, 1};

        postIndex = postorder.length - 1;

        Node root = buildTree(inorder, postorder, 0, inorder.length - 1);

        System.out.println("Preorder traversal of the constructed tree:");
        preorder(root);
    }
}