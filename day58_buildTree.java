//Build Tree from Inorder & Preorder

public class day58_buildTree {

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

    static int preIndex = 0;

    static Node buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {

        // No elements in this subtree
        if (inStart > inEnd) {
            return null;
        }

        // First element of preorder is the root
        Node root = new Node(preorder[preIndex]);
        preIndex++;

        // Find root in inorder
        int index = inStart;

        while (inorder[index] != root.data) {
            index++;
        }

        // Build left subtree
        root.left = buildTree(preorder, inorder, inStart, index - 1);

        // Build right subtree
        root.right = buildTree(preorder, inorder, index + 1, inEnd);

        return root;
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        int[] preorder = {1, 2, 4, 5, 3};
        int[] inorder = {4, 2, 5, 1, 3};

        preIndex = 0;

        Node root = buildTree(
            preorder,
            inorder,
            0,
            inorder.length - 1
        );

        postorder(root);
    }
}
