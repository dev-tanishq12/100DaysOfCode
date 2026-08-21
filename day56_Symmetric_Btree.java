public class day56_Symmetric_Btree {
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

    // Function to check if a binary tree is symmetric
    static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    // Function to check if two subtrees are mirrors of each other
    static boolean isMirror(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.data == right.data) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if (isSymmetric(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
