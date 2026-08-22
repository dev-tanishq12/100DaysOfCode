public class day57_mirror_Btree {
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

    // Function to create a mirror of a binary tree
    static Node mirror(Node root) { 
        
        if (root == null) {
            return null;
        }

        // Swap left and right
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively mirror both subtrees
        mirror(root.left);
        mirror(root.right);

        return root;
    }

    public void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        day57_mirror_Btree tree = new day57_mirror_Btree();

        mirror(root);

        tree.inorder(root);
    }

    
    

    
}
